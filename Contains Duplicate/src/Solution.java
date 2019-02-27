//Solution1
import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2)
            return false;
        else {
            Arrays.sort(nums);
            for(int i = 1; i < nums.length; ++i)
                if(nums[i] == nums[i-1])
                    return true;
             return false;
        }
    }
}

////Solution2
//import java.util.HashSet;
//import java.util.Set;
//
//class Solution {
//    public boolean containsDuplicate(int[] nums) {
//        if(nums.length < 2)
//            return false;
//        else {
//            Set<Integer>elements = new HashSet<>();
//            for(int elem : nums){
//                if(elements.contains(elem))
//                    return true;
//                else elements.add(elem);
//            }
//            return false;
//        }
//    }
//}