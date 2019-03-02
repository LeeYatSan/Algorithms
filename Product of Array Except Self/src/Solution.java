////Solution1 [Unaccepted: using division]
//class Solution {
//    public int[] productExceptSelf(int[] nums) {
//        if(nums.length == 0)
//            return nums;
//        int product = 1;
//        int zeroNum = 0;
//        for(int i : nums){
//            if(i == 0){
//                ++zeroNum;
//                continue;
//            }
//            product *= i;
//        }
//        int[] res = new int[nums.length];
//        for(int i = 0; i < nums.length;++i){
//            if(zeroNum > 1)
//                res[i] = 0;
//            else if(zeroNum == 1){
//                if(nums[i] != 0)
//                    res[i] = 0;
//                else res[i] = product;
//            }
//            else
//                res[i] = product/nums[i];
//        }
//        return res;
//    }
//}

//Solution2
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int curr = 1;
        for(int i = 0; i < len; ++i){
            res[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = len-1; i > -1; --i){
            res[i] *= curr;
            curr *= nums[i];
        }
        return res;
    }
}