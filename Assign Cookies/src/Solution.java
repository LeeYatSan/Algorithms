////Solution1: Counting Sort: Exceed the storage limit
//import java.util.Arrays;
//
//class Solution {
//    public int findContentChildren(int[] g, int[] s) {
//        if(g.length == 0 || s.length == 0)
//            return 0;
//        else{
//            g = countingSort(g);
//            s = countingSort(s);
//            int i = 0, j = 0;
//            while(i < g.length && j < s.length){
//                if(g[i] <= s[j]){
//                    ++i;
//                    ++j;
//                }
//                else ++j;
//            }
//            return i;
//        }
//    }
//    private int[] countingSort(int num[]){
//        int min = num[0], max = num[0];
//        for(int i : num){
//            if(i < min)
//                min = i;
//            else if(i > max)
//                max = i;
//        }
//        int bias = 0 - min;
//        int temp[] = new int[max - min + 1];
//        Arrays.fill(temp, 0);
//        for(int i : num)
//            ++temp[i + bias];
//        int i = 0, j = 0;
//        while (i < temp.length){
//            if(temp[i] != 0){
//                num[j] = i - bias;
//                ++j;
//                --temp[i];
//            }
//            else ++i;
//        }
//        return num;
//    }
//}


////Solution2: Radix Sort
//import java.util.ArrayList;
//
//class Solution {
//    public int findContentChildren(int[] g, int[] s) {
//        if(g.length == 0 || s.length == 0)
//            return 0;
//        else{
//            g = radixSort(g);
//            s = radixSort(s);
//            int i = 0, j = 0;
//            while(i < g.length && j < s.length){
//                if(g[i] <= s[j]){
//                    ++i;
//                    ++j;
//                }
//                else ++j;
//            }
//            return i;
//        }
//    }
//
//    private int[] radixSort(int[] arr){
//        int max = arr[0];
//        for(int i : arr){//find the max value in the array
//            if(max < i)
//                max = i;
//        }
//        int mod = 10, div = 1, max_digit = 0;
//        while(max != 0){//calculate the digits of the max value
//            max/=10;
//            ++max_digit;
//        }
//        ArrayList<ArrayList<Integer>>buckets = new ArrayList<>();
//        for(int i = 0; i < 10; i++)
//            buckets.add(new ArrayList<>());
//        for(int i = 0; i < max_digit; mod*=10, div*=10, ++i){
//            for(int elem : arr)
//                buckets.get((elem%mod)/div).add(elem);
//            int index = 0;
//            for(int k = 0; k < buckets.size(); ++k){
//                ArrayList<Integer> curr = buckets.get(k);
//                for(int j = 0; j < curr.size(); ++j)
//                    arr[index++] = curr.get(j);
//                curr.clear();
//            }
//        }
//        return arr;
//    }
//}

//Solution3: Arrays.sort
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g.length == 0 || s.length == 0)
            return 0;
        else{
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0, j = 0;
            while(i < g.length && j < s.length){
                if(g[i] <= s[j]){
                    ++i;
                    ++j;
                }
                else ++j;
            }
            return i;
        }
    }
}