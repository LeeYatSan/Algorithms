import java.util.Scanner;

public class Main {

    private static final int ERROR_VAL = -1;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int len;
        int[] arr;

        len = in.nextInt();
        arr = new int[len];

        for(int i = 0; i < len; i++){
            arr[i] = in.nextInt();
        }

        System.out.println("Result = " + getTheMaxAdjancentDifference(arr));

    }


    private static int getTheMaxAdjancentDifference(int[] arr){

        int len = arr.length;

        if(len== 0){ return ERROR_VAL; }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //获取数组最大值
        for(int i = 0; i < len; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        if(max == min){ return 0; }

        int bucketSize = len+1;
        int[] bucketMax = new int[bucketSize];
        int[] bucketMin = new int[bucketSize];
        boolean[] hasNum = new boolean[bucketSize];

        //装入桶中
        for(int i = 0; i < len; i++){
            int bucketId = calBucketId(arr[i], len, max, min);
            bucketMax[bucketId] = hasNum[bucketId] ? Math.max(bucketMax[bucketId], arr[i]) : arr[i];
            bucketMin[bucketId] = hasNum[bucketId] ? Math.min(bucketMin[bucketId], arr[i]) : arr[i];
            hasNum[bucketId] = true;
        }

        int maxDiff = 0;
        int lastMax = bucketMax[0];

        //寻找桶间最大差值
        for(int i = 1; i < bucketSize; i++){
            if(hasNum[i]){
                maxDiff = Math.max(maxDiff, bucketMin[i] - lastMax);
                lastMax = bucketMax[i];
            }
        }
        return maxDiff;
    }


    private static int calBucketId(long curr, long len, long max, long min){
        return ((int)((curr-min)*len/(max-min)));
    }
}
