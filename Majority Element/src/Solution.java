////Solution1
//import java.util.Arrays;
//
//class Solution{
//    public int majorityElement(int[] nums){
//        if(nums.length == 0)
//            return 0;
//        else if(nums.length == 1)
//            return nums[0];
//        else {
//            Arrays.sort(nums);
//            int count =1 , majority = nums[0], max_count = 0;
//            for(int i = 1; i < nums.length; ++i){
//                if(nums[i] == nums[i-1])
//                    ++count;
//                else count = 1;
//                if(count > max_count){
//                    majority = nums[i];
//                    max_count = count;
//                }
//            }
//            return majority;
//        }
//    }
//}

////Solution2
//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
//    public int majorityElement(int[] nums) {
//        if(nums.length == 0)
//            return 0;
//        else {
//            Map<Integer, Integer>numMap = new HashMap<>();
//            for(int elem : nums){
//                if(numMap.containsKey(elem))
//                    numMap.put(elem, numMap.get(elem)+1);
//                else numMap.put(elem, 1);
//            }
//            int max_count = 1;
//            int majority = nums[0];
//            for(Map.Entry<Integer, Integer>curr : numMap.entrySet()){
//                if(curr.getValue() > max_count){
//                    max_count = curr.getValue();
//                    majority = curr.getKey();
//                }
//            }
//            return majority;
//        }
//    }
//}


////Solution3
//class Solution {
//    public int majorityElement(int[] nums) {
//        if(nums.length == 0)
//            return 0;
//        else {
//            int count = 1;
//            int res = nums[0];
//            for(int num : nums){
//                if(num == res)
//                    ++count;
//                else {
//                    --count;
//                    if(count == 0){
//                        count = 1;
//                        res = num;
//                    }
//                }
//            }
//            return res;
//        }
//    }
//}

//Solution4
import java.util.Arrays;
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0)
            return 0;
        else {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }
}
