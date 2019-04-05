import java.util.Scanner;

////Solution1
//public class Main {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//
//        while(in.hasNext()){
//            int K = in.nextInt();
//            int A = in.nextInt();
//            int X = in.nextInt();
//            int B = in.nextInt();
//            int Y = in.nextInt();
//
//            final int mod = 1000000007;
//
//            int[] p = new int[X+Y+1];
//            for(int i = 1; i <= X; ++i)
//                p[i] = A;
//            for(int i = X+1; i <= X+Y; ++i)
//                p[i] = B;
//
//            long dp[] = new long[K+1];
//            dp[0] = 1;
//
//            for(int i = 1; i <= X+Y; ++i){
//                for(int j = K; j >=p[i]; --j)
//                    dp[j] = (dp[j]%mod + dp[j-p[i]]%mod)%mod;
//            }
//
//            System.out.println(dp[K]%mod);
//        }
//    }
//}



//Solution1
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int K = in.nextInt();
            int A = in.nextInt();
            int X = in.nextInt();
            int B = in.nextInt();
            int Y = in.nextInt();

            final int mod = 1000000007;

            int[] p = new int[X+Y+1];
            for(int i = 1; i <= X; ++i)
                p[i] = A;
            for(int i = X+1; i <= X+Y; ++i)
                p[i] = B;

            long dp[][] = new long[X+Y+1][K+1];
            dp[0][0] = 1;

            for(int i = 1; i <= X+Y; ++i){
                for(int j = 0; j <= K; ++j){
                    if(j >= p[i])
                        dp[i][j] = (dp[i-1][j]%mod + dp[i-1][j-p[i]]%mod)%mod;
                    else
                        dp[i][j] = dp[i-1][j]%mod;
                }
            }

            System.out.println(dp[X+Y][K]%mod);
        }
    }
}