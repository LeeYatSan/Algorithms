import java.util.ArrayList;

public class RadixSort extends Sort {

    RadixSort(int[] arr){
        super(arr);
    }

    public void coreSort(){
        int max = arr[0];
        for(int i : arr){//find the max value in the array
            if(max < i)
                max = i;
        }
        int mod = 10, div = 1, max_digit = 0;
        while(max != 0){//calculate the digits of the max value
            max/=10;
            ++max_digit;
        }
        ArrayList<ArrayList<Integer>>buckets = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            buckets.add(new ArrayList<>());
        for(int i = 0; i < max_digit; mod*=10, div*=10, ++i){
            for(int elem : arr)
                buckets.get((elem%mod)/div).add(elem);
            int index = 0;
            for(int k = 0; k < buckets.size(); ++k){
                ArrayList<Integer> curr = buckets.get(k);
                for(int j = 0; j < curr.size(); ++j)
                    arr[index++] = curr.get(j);
                curr.clear();
            }
        }
    }
}
