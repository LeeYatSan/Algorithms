import java.util.Arrays;

public class OneZeroKnapsackBT {

    Knapsack[] knapsacks;
    int capacity;
    int currWeight;
    int maxProfit;
    int currProfit;
    int num;

    public OneZeroKnapsackBT(int[] weight, int[] value, int capacity) {
        if(value.length != weight.length || value.length*weight.length == 0){
            return;
        }
        this.num = value.length;
        this.capacity = capacity;
        this.knapsacks = new Knapsack[num];
        for(int i = 0; i < num; ++i){
            knapsacks[i] = new Knapsack(weight[i], value[i]);
        }
        Arrays.sort(knapsacks);
    }


    private int solve(int i) {

        // 当没有物品可以放入背包时，当前价值为最优价值
        if (i >= num) {
            maxProfit = currProfit;
            return maxProfit;
        }

        // 首要条件：放入当前物品，判断物品放入背包后是否小于背包的总承重
        if (currWeight + knapsacks[i].getWeight() <= capacity) {
            // 将物品放入背包中的状态
            currWeight += knapsacks[i].getWeight();
            currProfit += knapsacks[i].getValue();

            // 选择下一个物品进行判断
            maxProfit = solve(i + 1);

            // 将物品从背包中取出的状态
            currWeight -= knapsacks[i].getWeight();
            currProfit -= knapsacks[i].getValue();
        }

        // 次要条件：不放入当前物品，放入下一个物品可能会产生更优的价值，则对下一个物品进行判断
        // 当前价值+剩余价值<=最优价值，不需考虑右子树情况，由于最优价值的结果是由小往上逐层返回，
        // 为了防止错误的将单位重量价值大的物品错误的剔除，需要将物品按照单位重量价值从大到小进行排序
        if (currProfit + getSurplusValue(i + 1) > maxProfit) {
            // 选择下一个物品进行判断
            maxProfit = solve(i + 1);
        }
        return maxProfit;
    }

    // 获得物品的剩余总价值
    private int getSurplusValue(int i) {
        int surplusValue = 0;
        for (int j = i; j < num; j++){
            surplusValue += knapsacks[i].getValue();
        }
        return surplusValue;
    }


    public void maxProfit(){
        System.out.println("Max Profit: " + solve(0));
    }

    public static void main(String[] args){

        int[] value = {20, 30, 65, 40, 60};
        int[] weight = {10, 20, 30, 40, 50};
        int maxLbs = 100;
        long startTime = System.nanoTime();
        (new OneZeroKnapsackBT(weight, value, maxLbs)).maxProfit();
        long endTime = System.nanoTime();
        System.out.println("Executing Time: " + (endTime-startTime));
    }
}


class Knapsack implements Comparable<Knapsack> {
    /** 物品重量 */
    private int weight;
    /** 物品价值 */
    private int value;
    /** 单位重量价值 */
    private double unitValue;

    public Knapsack(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.unitValue = (weight == 0) ? 0 : (double) value / (double)weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getUnitValue() {
        return unitValue;
    }

    @Override
    public int compareTo(Knapsack snapsack) {
        double value = snapsack.unitValue;
        if (unitValue > value)
            return 1;
        if (unitValue < value)
            return -1;
        return 0;
    }

}