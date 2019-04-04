//public class Solution {
//    public void reOrderArray(int [] array) {
//        int currEven = 0;
//        int len = array.length;
//        if(len < 2)
//            return;
//        for(int i = 0; i < len; ++i){
//            if(!isOdd(array[i])){
//                if(isOdd(array[currEven]))
//                    currEven = i;
//                ++i;
//                while(i < len && !isOdd(array[i]))
//                    ++i;
//                if(i < len)
//                    swap(array, currEven++, i);
//            }
//            else if(!isOdd(array[currEven]))
//                swap(array, currEven++, i);
//        }
//    }
//
//    private void swap(int[] arr, int indexA, int indexB){
//        arr[indexA] = new Integer[]{arr[indexB], arr[indexB] = arr[indexA]}[0];
//    }
//
//    private boolean isOdd(int num){
//        return num%2 == 1;
//    }
//}


public class Solution {
    public void reOrderArray(int [] array) {
        int currEven = 0;
        int len = array.length;
        if(len < 2)
            return;
        int[] odd = new int[len];
        int[] even = new int[len];
        int oddIndex = 0, evenIndex = 0, index = 0, oddCount = 0, evenCount = 0;
        for(int curr : array){
            if(isOdd(curr)){
                odd[oddIndex++] = curr;
                ++oddCount;
            }
            else{
                even[evenIndex++] = curr;
                ++evenCount;
            }
        }
        for(int i = 0; i < oddCount; ++i)
            array[index++] = odd[i];
        if(index >= len)
            return;
        for(int i = 0; i < evenCount; ++i)
            array[index++] = even[i];
    }

    private void swap(int[] arr, int indexA, int indexB){
        arr[indexA] = new Integer[]{arr[indexB], arr[indexB] = arr[indexA]}[0];
    }

    private boolean isOdd(int num){
        return num%2 == 1;
    }
}