import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        if(len < 3)
            return results;
        for(int low = 0; low < len; ++low){
            if(low > 0 && nums[low] == nums[low-1])
                continue;
            int mid = low+1;
            int high = len-1;
            while(mid < high){
                int currSum = nums[low]+nums[mid]+nums[high];
                if(currSum == 0){
//                    List<Integer> result = new ArrayList<>();
//                    result.add(nums[low]);
//                    result.add(nums[mid]);
//                    result.add(nums[high]);
//                    results.add(result);
                    results.add(Arrays.asList(nums[low], nums[mid], nums[high]));
                    while(nums[++mid] == nums[mid-1] && mid < high);
                }
                else if(currSum > 0)
                    while(nums[--high] == nums[high+1] && high > mid);

                else
                    while(nums[++mid] == nums[mid-1] && mid < high);

            }
        }
        return results;
    }
}