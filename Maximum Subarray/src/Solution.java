class Solution {
public int maxSubArray(int[] nums){
        int max = 0;
        int res = nums[0];
        for(int i : nums){
            if(max > 0) max += i;
            else max = i;
            res = Math.max(res, max);
        }
        return res;
    }
}
