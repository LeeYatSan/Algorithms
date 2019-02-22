class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        else{
            int[] profits = new int[nums.length];
            profits[0] = nums[0];
            profits[1] = Math.max(nums[0], nums[1]);
            for(int i = 2; i < nums.length; ++i){
                profits[i] = Math.max(profits[i-2]+nums[i], profits[i-1]);
            }
            return profits[nums.length-1];
        }
    }
}