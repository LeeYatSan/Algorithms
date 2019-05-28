import java.util.Arrays;

public class OneZeroKnapsack {

    int[] weight;
    int[] value;
    double[] valPerWeight;
    int capacity;
    int num;
    int[][] profit;

    public OneZeroKnapsack(int[] weight, int[] value, int capacity) {
        if(value.length != weight.length || value.length*weight.length == 0){
            return;
        }
        this.weight = weight;
        this.value = value;
        this.capacity = capacity;
        this.num = value.length;
        this.valPerWeight = new double[num];
        this.profit = new int[num+1][capacity+1];
        Arrays.sort(weight);
        Arrays.sort(value);
        Arrays.copyOf(weight, weight.length+1);
        Arrays.copyOf(value, value.length+1);
        for(int i = 0; i < num; ++i){
            if(weight[i] > 0){
                valPerWeight[i] = value[i]/weight[i];
            }
            else{
                valPerWeight[i] = 0;
            }
        }
    }

    public void maxProfit(){
        for(int i = 1; i < num; ++i){
            for(int j = 1; j <= capacity; j++){
                if(weight[i] <= j){
                    if(profit[i-1][j] < profit[i-1][j-weight[i]] + value[i]){
                        profit[i][j] = value[i] + profit[i-1][j-weight[i]];
                    }
                    else{
                        profit[i][j] = profit[i-1][j];
                    }
                }
                else{
                    profit[i][j] = profit[i-1][j];
                }
            }
        }
//        for(int i = 0; i < num; i++) {
//            for(int j = 0; j <= capacity; j++)
//                System.out.print(profit[i][j] + " ");
//            System.out.println();
//        }
        System.out.println("Max Profit: " + profit[num-1][capacity]);


    }

    public static void main(String[] args){

         int[] value = {20, 30, 65, 40, 60};
         int[] weight = {10, 20, 30, 40, 50};
         int maxLbs = 100;
        long startTime = System.nanoTime();
        (new OneZeroKnapsack(weight, value, maxLbs)).maxProfit();
        long endTime = System.nanoTime();
        System.out.println("Executing Time: " + (endTime-startTime));
    }
}


