public class Main {
    public static void main(String[] args){
        int m = 3, n = 3;
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        Solution s = new Solution();
        s.merge(nums1, m, nums2, n);
        for(int i : nums1){
            System.out.print(i+" ");
        }
    }
}
