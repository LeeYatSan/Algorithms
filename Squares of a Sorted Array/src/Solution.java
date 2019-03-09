//Solution1
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        if(len == 0)
            return null;
        int mid = 0;
        for(int i = 0; i < len-1; ++i){
            if(A[i] < 0 && A[i+1] >= 0){
                mid = i+1;
                break;
            }
        }
        int[] res = new int[len];
        int k = 0, i = mid, j = mid-1;
        while(i < len && j >= 0)
            res[k++] = A[i]*A[i] < A[j]*A[j] ? A[i]*A[i++] : A[j]*A[j--];
        while(i < len)
            res[k++] = A[i]*A[i++];
        while(j >= 0)
            res[k++] = A[j]*A[j--];
        return res;
    }
}