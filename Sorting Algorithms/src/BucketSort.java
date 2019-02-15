import java.util.ArrayList;

public class BucketSort extends Sort {

    BucketSort(int[] arr){
        super(arr);
    }

    public void coreSort(){

        ArrayList<Integer> temp = new ArrayList<>();//transfer from basic data array to ArrayList for better implementation, but this process is not included in Bucket Sort algorithm
        for(int i : arr)
            temp.add(i);
        temp = bucketSort(temp, 5);
        for(int i = 0; i < temp.size(); ++i)
            arr[i] = temp.get(i);
    }

    private  ArrayList<Integer> bucketSort(ArrayList<Integer> arraylist, int bucket_size){
        int min = arraylist.get(0), max = arraylist.get(0);//to keep the min and max value in unsorted array
        for(int i : arraylist){
            if(i > max)
                max = i;
            if(i < min)
                min = i;
        }
        int bucket_num = (max-min)/bucket_size+1;//calculate the number of bucket
        ArrayList<ArrayList<Integer>>buckets = new ArrayList<>(bucket_num);//build an array of buckets
        for(int i = 0; i < bucket_num; ++i)
            buckets.add(new ArrayList<>());
        for(int i : arraylist)//put each element in the array into the corresponding bucket
            buckets.get((i-min)/bucket_size).add(i);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < bucket_num; ++i){//sort the array in each bucket

          //the following implementation sorts the array in each bucket by recursive bucket sort. However, other sorting algorithms are also available at here.
            ArrayList<Integer> curr = buckets.get(i);
            if(bucket_size > 1 && curr.size() != 0){
                if(bucket_num==1)//when there is only one bucket, we have to change the size of the bucket to increase the the number of bucket in next recurse, or an infinitely recurse will happen causing to exception
                    curr = bucketSort(curr, bucket_size-1);//to prevent infinitely recurse
                else
                    curr = bucketSort(curr, bucket_size);
            }
           //finish sorting each buckets.
            result.addAll(curr);//add all sorted array to the result array
        }
        return result;
    }
}
