//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//
//        while(in.hasNext()){
//            int num = in.nextInt();
//            if(num < 6 || num%2 == 1){
//                System.out.println(-1);
//                return;
//            }
//            int num8 = num/8;
//            int num6 = 0;
//            int mod8left = num%8;
//            boolean successful = false;
//            while(num8 >= 0)
//            {
//                if(mod8left%6 != 0){
//                    --num8;
//                    mod8left += 8;
//                }
//                else{
//                    num6 = mod8left/6;
//                    successful = true;
//                    break;
//                }
//            }
//            if(successful)
//                System.out.println(num6+num8);
//            else
//                System.out.println(-1);
//        }
//    }
//}


//import java.util.Scanner;
//
//public class Main {
//    static int min = Integer.MAX_VALUE;
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int n = in.nextInt();
//            dfs(n, 0);
//            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
//        }
//    }
//
//    static void dfs(int n, int bag) {
//        if (n == 0)
//            min = Math.min(min, bag);
//        if (n <= 6 || (6 < n && n < 8))
//            return;
//        dfs(n - 8, bag + 1);
//        dfs(n - 6, bag + 1);
//    }
//}


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int num = in.nextInt();
            if(num < 6){
                System.out.println(-1);
                return;
            }
            int[] dp = new int[num+1];
            dp[0] = 0;
            for(int i = 1; i < 6; ++i)
                dp[i] = -1;
            dp[6] = 1;
            dp[7] = -1;
            dp[8] = 1;

            for(int i = 9; i <= num; ++i){
                if(dp[i-6] != -1 && dp[i-8] != -1)
                    dp[i] = Math.min(dp[i-6], dp[i-8])+1;
                else if(dp[i-6] == -1 && dp[i-8] != -1)
                    dp[i] = dp[i-8]+1;
                else if(dp[i-6] != -1 && dp[i-8] == -1)
                    dp[i] = dp[i-6]+1;
                else
                    dp[i] = -1;
            }
            System.out.println(dp[num]);
        }
    }
}