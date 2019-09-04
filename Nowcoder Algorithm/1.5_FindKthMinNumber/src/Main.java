import java.util.Arrays;

public class Main {

    private static final String ERROR_MSG_INVALID_PARAMETERS = "Invalid Parameters!";

    public static void main(String[] args){

        int[] A = {1, 3, 5, 9, 11};
        int[] B = {2, 3, 6, 10};
        int[] res;

        int K = 4;

        res = getTopKs(A, B, K);

        if(res == null || res.length == 0){
            throw new RuntimeException("getTopKs: " + ERROR_MSG_INVALID_PARAMETERS);
        }
        for(int i : res){
            System.out.print(i + " ");
        }
    }

    //获取最大K个数
    private static int[] getTopKs(int[] A, int[] B, int K){
        if(A == null || B == null || K <= 0){ return null;}
        Arrays.sort(A);
        Arrays.sort(B);

        int lenA = A.length;
        int lenB = B.length;

        if(lenA == 0 && lenB == 0){ return null;}

        int[] res = new int[K];

        if(lenA == 0|| A[lenA-1] < B[0] ){
            System.arraycopy(B, lenB-K, res, 0, K);
        }
        else if(lenB == 0 || B[lenB-1] < A[0]){
            System.arraycopy(A, lenB-K, res, 0, K);
        }
        else{
            for(int i = lenA+lenB-K+1; i <= lenA+lenB; i++){
                res[i-lenA-lenB+K-1] = findKthMinNumber(A, B, i);
            }
        }

        return res;
    }

    //获取第K小的数
    private static int findKthMinNumber(int[] A, int[] B, int K){
        int lenA = A.length;
        int lenB = B.length;
        int[] longArr = lenA >= lenB ? A : B;
        int[] shortArr = lenA < lenB ? A : B;
        int lLen = longArr.length;
        int sLen = shortArr.length;

        if(1 <= K && K <= sLen){
            return getUpMedian(A, 0, K-1, B, 0, K-1);
        }
        else if(K > sLen && K <= lLen){
            int diff = K-sLen;
            if(longArr[diff-1] >= shortArr[sLen-1]){
                return longArr[diff-1];
            }
            return getUpMedian(shortArr, 0, sLen-1, longArr, diff, K-1);
        }
        else if(K > lLen && K <= sLen+lLen){
            if(shortArr[K-lLen-1] >= longArr[lLen-1]){
                return shortArr[K-lLen-1];
            }
            if(longArr[K-sLen-1] >= shortArr[sLen-1]){
                return longArr[K-sLen-1];
            }
            return getUpMedian(shortArr, K-lLen, sLen-1, longArr, K-sLen, lLen-1);
        }
        else{
            throw new RuntimeException("findKthMinNumber: " + ERROR_MSG_INVALID_PARAMETERS);
        }
    }

    //获取数组arr1、arr2的上中位数。主意两个数组的长度必须相等！
    public static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2,
                                  int e2) {
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (s1 < e1) {
            //中点
            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
            //i&1 若为0，则为偶数，为1则为奇数；所以(i&1)^1若为0，则为奇数，为1则为偶数
            offset = ((e1 - s1 + 1) & 1) ^ 1;
            if (a1[mid1] > a2[mid2]) {
                e1 = mid1;
                s2 = mid2 + offset;
            } else if (a1[mid1] < a2[mid2]) {
                s1 = mid1 + offset;
                e2 = mid2;
            } else {
                return a1[mid1];
            }
        }
        return Math.min(a1[s1], a2[s2]);
    }
}
