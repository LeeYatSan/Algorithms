class QuickSort {

    private int arr[];

    public QuickSort(int[] arr){
        this.arr = arr;
    }

    private void quickSort(int start, int end){
        if(start >= end)
            return;
        int pivotIndex = partition(start, end);
        quickSort(start, pivotIndex);
        quickSort(pivotIndex+1, end);
    }

    private int partition(int start, int end){
        int pivot = arr[start];
        while(start < end){
            while(start < end && pivot <= arr[end])
                --end;
            if(start < end)
                swap(start++, end);
            while(start < end && pivot >= arr[start])
                ++start;
            if(start < end)
                swap(start, end--);
        }
        return start;
    }

    public int[] getTheResult(){
        quickSort(0, arr.length-1);
        return arr;
    }


    private void swap(int indexA, int indexB){
        arr[indexA] = new Integer[]{arr[indexB], arr[indexB] = arr[indexA]}[0];
    }
}
