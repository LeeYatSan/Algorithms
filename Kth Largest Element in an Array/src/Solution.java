import java.util.Random;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return nums[quickSelect(nums, 0, len-1, len-k+1)];
    }

    //return the index of the kth smallest number
    //put nums that are <= pivot to the left
    //put nums that are  > pivot to the right
    int quickSelect(int[] arr, int start, int end, int k) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end-start+1)+start;
        swap(pivotIndex, end, arr);
        int left = start, right = end, pivot = arr[end];
        while (left < right)
            if (arr[left++] > pivot)
                swap(--left, --right, arr);
        swap(left, end, arr);
        int m = left-start+1; //count the nums that are <= pivot from start
        if (m == k)//pivot is the one!
            return left;
        else if (m > k)  //pivot is too big, so it must be on the left
            return quickSelect(arr, start, left-1, k);
        else //pivot is too small, so it must be on the right
            return quickSelect(arr, left+1, end, k-m);
    }

    private void swap(int indexA, int indexB, int[] arr){
        arr[indexA] = new int[]{arr[indexB], arr[indexB] = arr[indexA]}[0];
    }
}