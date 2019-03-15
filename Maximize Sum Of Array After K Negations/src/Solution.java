import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int len = A.length;
        if(len == 0)
            return 0;
        Arrays.sort(A);
        int curr = 0;
        int sum = 0;
        while(curr < len && K>0){
            if(A[curr] < 0){
                A[curr] *= -1;
                --K;
            }
            else if(A[curr] == 0)
                break;
            else{
                if(K%2 == 0)
                    break;
                else{
                    if(curr == 0 || A[curr] < A[curr-1])
                        A[curr] *= -1;
                    else
                        A[curr-1] *= -1;
                    break;
                }
            }
            ++curr;
        }
        for(curr = 0; curr < len; ++curr)
            sum += A[curr];
        return sum;
    }
}