////Solution1
//public class Solution {
//    public int findMin(int [] nums) {
//        int len = nums.length;
//        if(len == 0)
//            return 0;
//        else if(len == 1)
//            return nums[0];
//        else{
//            for(int i = 0; i+1 < len; ++i){
//                if(nums[i] > nums[i+1])
//                    return nums[i+1];
//            }
//            return nums[0];
//        }
//    }
//}


//Solution2 二分
public class Solution {
    public int findMin(int [] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        else if(len == 1)
            return nums[0];
        else{
            int start = 0, end = len-1;
            while(start <= end){
                int mid = (start+end)/2;
                if((mid >= 1 && nums[mid] < nums[mid-1]) || (mid == 0 && nums[mid] < nums[len-1]))
                    return nums[mid];
                if(nums[end] < nums[mid])
                    start = mid+1;
                else
                    end = mid-1;
            }
            return nums[start];
        }
    }
}