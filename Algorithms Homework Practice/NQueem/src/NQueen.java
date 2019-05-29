public class NQueen {

    private int max;
    private int[] array;
    private int scheme = 0;

    public NQueen(int max) {
        this.max = max;
        array = new int[max];
    }

    public int getScheme(){
        return scheme;
    }

    private void check(int curr) {
        //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所以只要最后一行摆完，说明已经得到了一个正确解
        if (curr == max) {
            print();
            ++scheme;
            return;
        }
        //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
        for (int i = 0; i < max; i++) {
            array[curr] = i;
            if (judge(curr)) {
                check(curr + 1);
            }
        }
    }

    private boolean judge(int curr) {
        for (int i = 0; i < curr; i++) {
            if (array[i] == array[curr] || Math.abs(array[curr] - array[i]) == Math.abs(curr- i)) {
                return false;
            }
        }
        return true;
    }

    private void print()  {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + 1 + " ");
        }
        System.out.println();
    }

    public static void getSchemes(int num){
        NQueen nQueen = new NQueen(num);
        nQueen.check(0);
        System.out.println("Schemes: " + nQueen.getScheme());
    }

    public static void main(String[] args) {
        int num = 8;
        getSchemes(num);
    }
}