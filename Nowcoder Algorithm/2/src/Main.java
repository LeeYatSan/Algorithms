import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final int ERROR_VAL = -1;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        if(len <= 0){ return ;}

        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = in.nextInt();
        }

        System.out.println("Result = " + getOptimizeDivisionNum(arr));
    }

    private static int getOptimizeDivisionNum(int[] arr){

        if(arr == null){return ERROR_VAL;}
        int len = arr.length;
        if(len == 0){return ERROR_VAL;}
        else if(len == 1){return 1;}

        //数组数据预处理，首先求出[0...i]区间的异或和，并将其结果记录在一个map中
        //Map<Val, LastPos>: Val -> [0...i]区间的异或和（即前缀异或和）的值作为Map的key;  LastPos -> Val出现的最后位置的序号作为Map的value
        Map<Integer, Integer> xorResults = new HashMap();

        //假设答案法：假设最优解在[0...i]区间
        //动态规划：动态规划数组dp[i]记录[0...i]区间上的最优划分个数
        /*
        两种情况：
        1. arr[i]所在的块是[0...i]区间上最后一个异或和为0的块 ： dp[i] = dp[j] + 1, j为i所在块的起始位置
        2. arr[i]所在的块不是[0...i]区间上最后一个异或和为0的块 :  dp[i] = dp[i-1]

        两种情况中取最大结果作为dp[i]的值
         */
        int[] dp = new int[len];
        dp[0] = 0;
        int currXorRes = 0;

        //异或和为0的情况：即使一个数都没有也存在着，因此初始化为在-1位置异或和为0
        xorResults.put(currXorRes, -1);

        for(int i = 0; i < len; i++){
            currXorRes ^= arr[i];

//            //dp[i]更新
            if(xorResults.containsKey(currXorRes)){
                int pre = xorResults.get(currXorRes);
                dp[i] = pre == -1 ? 1 : Math.max(dp[i-1], dp[pre]+1);
            }
            else{
                dp[i] = dp[i-1];
            }

//            if(xorResults.containsKey(currXorRes)){
//                int pre = xorResults.get(currXorRes);
//                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
//            }
//            if(i > 0){
//                dp[i] = Math.max(dp[i], dp[i-1]);
//            }

            xorResults.put(currXorRes, i);
        }
        return dp[len-1];
    }
}
