public class DirectInsertionSort extends Sort {

    DirectInsertionSort(int[] arr){
        super(arr);
    }

    public void coreSort(){
        int unsorted_first = 1;//the index of the first element of the unsorted part
        for(; unsorted_first < arr.length; ++unsorted_first){
            int curr = arr[unsorted_first];//keep the value of the first element in the unsorted part
            int i = unsorted_first - 1;
            for(; i > -1 && arr[i] > curr; --i){//move ahead to the first element from the last element of the sorted part, and exchange the value if current value is larger than the current value of the first element in the unsorted part. This process will loop until find a value is smaller than the current first element of the unsorted part.
                arr[i+1] = arr[i];
            }
            arr[i+1] = curr;
        }
    }
}