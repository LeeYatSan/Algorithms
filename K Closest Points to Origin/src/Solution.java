////Solution1: Merge Sort
//class Solution {
//    public int[][] kClosest(int[][] points, int K) {
//        int len = points.length;
//        int[][]results = new int[K][2];
//        for(int i = 0; i < K; ++i)
//            results[i] = new int[2];
//        if(len == 0)
//            return results;
//        mergeSort(0, len-1, points, K);
//        for(int i = 0; i < K; ++i){
//            results[i][0] = points[i][0];
//            results[i][1] = points[i][1];
//        }
//        return results;
//    }
//
//    private void mergeSort(int start, int end, int[][] arr, int K){
//        if(end-start<1)
//            return;
//        int mid = (start+end)/2;
//        mergeSort(start, mid, arr, K);
//        mergeSort(mid+1, end, arr, K);
//        merge(start, end, arr);
//    }
//
//    private void merge(int start, int end, int[][] arr){
//        int mid = (start+end)/2;
//        int i = start, j = mid+1, k = 0;
//        int[][] results = new int[end-start+1][2];
//        while(i <= mid && j <= end){
//            if(arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1] < arr[j][0]*arr[j][0]+arr[j][1]*arr[j][1]){
//                results[k][0] = arr[i][0];
//                results[k++][1] = arr[i++][1];
//            }
//            else{
//                results[k][0] = arr[j][0];
//                results[k++][1] = arr[j++][1];
//            }
//        }
//        while(i <= mid){
//            results[k][0] = arr[i][0];
//            results[k++][1] = arr[i++][1];
//        }
//        while(j <= end){
//            results[k][0] = arr[j][0];
//            results[k++][1] = arr[j++][1];
//        }
//        for(int l = 0; l < results.length; ++l){
//            arr[start+l][0] = results[l][0];
//            arr[start+l][1] = results[l][1];
//        }
//    }
//}


//Solution2: Divide and Conquer

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        work(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void work(int i, int j, int K) {
        if (i >= j) return;
        int oi = i, oj = j;
        int pivot = dist(ThreadLocalRandom.current().nextInt(i, j));

        while (i < j) {
            while (i < j && dist(i) < pivot) i++;
            while (i < j && dist(j) > pivot) j--;
            swap(i, j);
        }

        if (K <= i - oi + 1)
            work(oi, i, K);
        else
            work(i+1, oj, K - (i - oi + 1));
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}



