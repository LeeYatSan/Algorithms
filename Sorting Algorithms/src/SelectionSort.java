public class SelectionSort extends Sort {

    SelectionSort(int[] arr){
        super(arr);
    }

    //core algorithms of bubble sort
    public void coreSort() {
        int unsorted_min = 0, sorted_last; //the former is the index of the min value of unsorted part, and the later is the index of the last element in the sorted part
        for(sorted_last = 0; sorted_last < arr.length-1; ++sorted_last){
            for(int j = sorted_last+1; j < arr.length; ++j)//find the min value within the unsorted part
                if(arr[j] < arr[unsorted_min])
                    unsorted_min = j;
            swap(sorted_last, unsorted_min);
        }
    }
}