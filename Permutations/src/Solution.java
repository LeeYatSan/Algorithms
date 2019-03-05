import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        exchange(0, nums, results);
        return results;
    }

    private void exchange(int start, int[] nums, List<List<Integer>> result){
        int len = nums.length;
        if(start == len-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : nums)
                list.add(num);
            result.add(list);
        }
        else {
            for(int i = start; i < len; ++i){
                swap(start, i, nums);
                exchange(start+1, nums, result);
                swap(start, i, nums);
            }
        }
    }

    private void swap (int indexA, int indexB, int[] nums){
        nums[indexA] = new int[]{nums[indexB], nums[indexB] = nums[indexA]}[0];
    }
}