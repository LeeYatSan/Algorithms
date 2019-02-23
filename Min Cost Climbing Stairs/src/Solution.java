////solution1
//class Solution {
//    public int minCostClimbingStairs(int[] cost) {
//        if(cost.length == 0)
//            return 0;
//        else if(cost.length == 1)
//            return cost[0];
//        else {
//            int memo_1 = cost[0];
//            int memo_2 = cost[1];
//            int temp;
//            for(int i = 2; i < cost.length; ++i){//dp[i]=min{dp[i-1], dp[i-2]}+cost[i+1]
//                temp = memo_2;
//                memo_2 = Math.min(memo_1, memo_2)+cost[i];
//                memo_1 = temp;
//            }
//            return Math.min(memo_1, memo_2);
//        }
//    }
//}

//solution2
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len == 0)
            return 0;
        else if(len == 1)
            return cost[0];
        else {
            int memo[] = new int[len];
            memo[0] = cost[0];
            memo[1] = cost[1];
            for(int i = 2; i < len; ++i)
                memo[i] = Math.min(memo[i-1], memo[i-2]) + cost[i];
            return Math.min(memo[len-1], memo[len-2]);
        }
    }
}