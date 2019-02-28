////Solution1
//import java.util.Arrays;
//
//class Solution {
//    public int singleNumber(int[] nums) {
//        int len = nums.length;
//        if(len == 0)
//            return 0;
//        else if(len == 1)
//            return nums[0];
//        else {
//            Arrays.sort(nums);
//            if(nums[0] != nums[1])
//                return nums[0];
//            else if(nums[len-1] != nums[len-2])
//                return nums[len-1];
//            else {
//                for(int i = 1; i < len-1; ++i){
//                    if(nums[i] != nums[i-1] && nums[i] != nums[i+1])
//                        return nums[i];
//                }
//                return 0;
//            }
//        }
//    }
//}


////Solution2
//import java.util.HashSet;
//import java.util.Set;
//
//class Solution {
//    public int singleNumber(int[] nums) {
//        Set<Integer> temp = new HashSet<>();
//        int arrSum = 0, setSum = 0;
//        for(int elem : nums){
//            temp.add(elem);
//            arrSum += elem;
//        }
//        for(int elem : temp)
//            setSum += elem;
//        return 2*setSum-arrSum;
//    }
//}


class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int elem : nums)
            result ^= elem;
        return result;
    }
}