import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> results = new ArrayList<>(1<<len);
        for(int i = 0; i < 1<<len; ++i){
            ArrayList<Integer> result = new ArrayList<>();
            for(int j = 0; j < len; ++j){
                if((i & 1<<j) != 0)
                    result.add(nums[j]);
            }
            results.add(result);
        }
        return results;
    }
}