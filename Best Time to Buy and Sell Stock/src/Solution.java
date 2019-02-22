////solution 1
//class Solution {
//    public int maxProfit(int[] prices) {
//        if(prices.length == 0)
//            return 0;
//        int profit = 0;
//        int pre_min = prices[0];
//        for(int i = 1; i < prices.length; ++i){
//            if(prices[i] > prices[i-1]){
//                for(int j = 0; j < i; ++j){
//                    if(prices[i] > prices[j])
//                       pre_min = Math.min(pre_min, prices[j]);
//                }
//                profit = Math.max(profit, prices[i] - pre_min);
//            }
//        }
//        return profit;
//    }
//}

//solution 2: only one traverse
class Solution{
    public int maxProfit(int[] prices){
        if(prices.length == 0)
            return 0;
        int min_price = prices[0];
        int max_profit = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] < min_price)
                min_price = prices[i];
            else if(max_profit < prices[i] - min_price)
                max_profit = prices[i] - min_price;
        }
        return max_profit;
    }
}