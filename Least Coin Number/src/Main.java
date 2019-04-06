import java.util.Arrays;
import java.util.Scanner;

/*
 * 假设有 1 元，3 元，5 元的硬币若干（无限），现在需要凑出 11 元，问如何组合才能使硬币的数量最少？
 */
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            int[] array = {6, 8};
            System.out.println((new Main().getLeastNum(array, num)));
        }
    }

    private int getLeastNum(int[] array, int n){
        int lens = array.length;
        if(lens == 0 || n<0)
            return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);

        for(int i = 1; i < n+1; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < lens; j++){
                if(i-array[j] >= 0){
                    int temp = dp[i-array[j]]+1;
                    if(temp < min)
                        min = temp;
                }
            }
            if(min != Integer.MAX_VALUE)
                dp[i] = min;
            else
                dp[i] = -1;
        }
        return dp[n];
    }
}
