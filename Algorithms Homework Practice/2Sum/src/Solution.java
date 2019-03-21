import java.util.Arrays;

class Solution {
    public int[] getTheTwoValue(int[] arr, int K){
        int len = arr.length;
        int[] res = new int[2];
        if(len < 2){
            System.out.println("Not enough value in the array!");
            return res;
        }
        Arrays.sort(arr);
        for(int curr : arr){
            int target = K-curr;
            int theOtherVal = SearchTheOtherVal(arr, 0, len-1, target);
            if(theOtherVal == target){
                res[0] = curr;
                res[1] = theOtherVal;
                break;
            }
        }
        System.out.println("The value-pair is not found!");
        return res;
    }

    private int SearchTheOtherVal(int[] arr, int start, int end, int target){
        if(end <= start)
            return target == arr[end] ? arr[end] : -1;
        int mid = (start+end)/2;
        if(target == arr[mid])
            return arr[mid];
        else if(target < arr[mid])
            return SearchTheOtherVal(arr, start, mid-1, target);
        else
            return SearchTheOtherVal(arr, mid+1, end, target);
    }
}
