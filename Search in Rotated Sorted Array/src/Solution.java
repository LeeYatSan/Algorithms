class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int start, int end){
        int mid = (start+end)/2;
        if(start > end)
            return -1;
        else if(nums[mid] == target)
            return mid;
        else if(nums[mid] < nums[end]){
            if(target >= nums[mid] && target <= nums[end])
                return search(nums, target, mid+1, end);
            else
                return search(nums, target, start, mid-1);
        }
        else{
            if(nums[start] <= target && target < nums[mid])
                return search(nums, target, start, mid-1);
            else
                return search(nums, target, mid+1, end);
        }
    }
}