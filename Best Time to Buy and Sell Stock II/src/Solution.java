//solution1
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        else{
            int curr_min = prices[0], curr_max = prices[0], profit = curr_max - curr_min;
            for(int i = 1; i < prices.length; ++i){
                if(prices[i] >= curr_max)
                    curr_max = prices[i];
                else{
                    profit += curr_max - curr_min;
                    curr_min = prices[i];
                    curr_max = prices[i];
                }
            }
            profit += curr_max - curr_min;
            return profit;
        }
    }
}

////solution2
//class Solution {
//    public int maxProfit(int[] prices) {
//        if(prices.length == 0)
//            return 0;
//        else{
//            int profit = 0;
//            for(int i = 1; i < prices.length; ++i){
//                if(prices[i] > prices[i-1])
//                    profit += prices[i] - prices[i-1];
//            }
//            return profit;
//        }
//    }
//}