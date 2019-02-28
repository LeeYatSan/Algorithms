////Solution1
//import java.util.ArrayList;
//
//class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        ArrayList<Integer>num = new ArrayList<>();
//        int i = 0, j = 0;
//        while(i < m && j < n){
//            if(nums1[i] <= nums2[j])
//                num.add(nums1[i++]);
//            else num.add(nums2[j++]);
//        }
//        while(i < m)
//            num.add(nums1[i++]);
//        while(j < n)
//            num.add(nums2[j++]);
//        for(int k = 0; k < num.size(); ++k)
//            nums1[k] = num.get(k);
//    }
//}


////Solution2
//import java.util.Arrays;
//
//class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for(int i = 0; i < n; ++i)
//            nums1[m+i] = nums2[i];
//        Arrays.sort(nums1);
//    }
//}


//Solution3
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;
        --m;
        --n;
        while(m >= 0 && n >= 0)
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        while(n >= 0)
            nums1[p--] = nums2[n--];
    }
}