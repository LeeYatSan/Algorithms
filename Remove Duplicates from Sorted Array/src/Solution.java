//class Solution {
//    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0 || nums.length == 1) return nums.length;
//        int curr = 0, next = 1;
//        while(curr < nums.length && next < nums.length){
//            if(nums[curr] >= nums[curr+1]){
//                while(nums[curr] >= nums[next]){
//                    ++next;
//                    if(next == nums.length)
//                        break;
//                }
//                if(next < nums.length)
//                    nums[++curr] = nums[next];
//            }
//            ++curr;
//        }
//        return ++curr;
//    }
//}

//class Solution {
//    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0 || nums.length == 1) return nums.length;
//        int curr = 0, next = 1;
//        while(curr < nums.length && next < nums.length){
//            if(nums[curr] == nums[curr+1]){
//                while(nums[curr] >= nums[next]){
//                    ++next;
//                    if(next == nums.length)
//                        break;
//                }
//                if(next < nums.length)
//                    nums[++curr] = nums[next];
//            }
//            ++curr;
//        }
//        return ++curr;
//    }
//}

////solution1
//class Solution{
//    public int removeDuplicates(int[] nums){
//        if(nums.length == 0 || nums.length == 1) return nums.length;
//        int curr = 0, next = curr+1;
//        while(next < nums.length){
//            curr++;
//            while(nums[curr-1] >= nums[next]){
//                ++next;
//                if(next == nums.length)
//                    break;
//            }
//            if(next < nums.length)
//                nums[curr] = nums[next];
//        }
//        return curr;
//    }
//}

//solution2
class Solution{
    public int removeDuplicates(int[] nums){
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int curr = 0, next = curr+1;
        while(next < nums.length){
            if(nums[curr] != nums[next])
                nums[++curr] = nums[next];
            ++next;
        }
        return curr+1;
    }
}
