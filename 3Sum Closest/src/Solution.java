import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int currSum = nums[0]+nums[1]+nums[2];
        int closestSum = currSum;
        for(int low = 0; low < len; ++low){
            int mid = low+1;
            int high = len-1;
            while(mid < high){
                currSum = nums[low]+nums[mid]+nums[high];
                if(Math.abs(currSum-target) < Math.abs(closestSum-target))
                    closestSum = currSum;
                if(currSum > target)
                    --high;
                else if (currSum < target)
                    ++mid;
                else
                    return target;
            }
        }
        return closestSum;
    }
}