public class QuickSort extends Sort {
    QuickSort(int[] arr){
        super(arr);
    }

    public void coreSort(){
        quickSort(0, arr.length-1);
    }

    private void quickSort(int start, int end){
        if(start >= end)
            return;
        int privot_index = partition(start, end);
        quickSort(start, privot_index);
        quickSort(privot_index+1, end);
    }

    private int partition(int start, int end){
        int pivot = arr[start];//we select the first element of the sequence as the pivot, which means we need to traverse the sequence from the last firstly
        while(start < end){
            while(start < end && pivot <= arr[end])//traverse the sequence until we find an element which value is smaller than the pivot's value
                --end;
            if(start < end)//if we find an element which value is smaller than the pivot's value, then swap them
                swap(start++, end);
            while(start < end && pivot >= arr[start])//traverse the sequence from the head until we find an element which value is larger than the pivot's value
                start++;
            if(start < end)
                swap(start, end--);//if we find an element which value is larger than the pivot's value, then swap them
        }
        return start;
    }
}
