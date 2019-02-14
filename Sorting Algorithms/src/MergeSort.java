public class MergeSort extends Sort{

    MergeSort(int[] arr){
        super(arr);
    }

    public void coreSort(){
        mergeSort(0, arr.length-1);
    }

    private void mergeSort(int start, int end){
        int len = end-start+1;
        if(len<2)//to stop the recursive
            return;
        int mid = (end+start)/2;
        mergeSort(start, mid);//recurse the left sub-sequence
        mergeSort(mid+1, end);//recurse the right sub-sequence
        merge(start, end);
    }

    private void merge(int start, int end){
        int[] temp = new int[end-start+1];
        int mid = (end+start)/2;
        int left = start, right = mid+1, i = 0;
        while(left <= mid &&  right <= end){//compare the elements in the left and right sub-sequence
            if(arr[left] < arr[right])
                temp[i++] = arr[left++];
            else
                temp[i++] = arr[right++];
        }
        while(left <= mid)//the remain elements in the left sub-sequence are definitely smaller than the remain elements in right sub-sequence
            temp[i++] = arr[left++];
        while(right <= end)
            temp[i++] = arr[right++];
        for(i = 0; i < temp.length; ++i)//move the elements in the temp array to the array arr
            arr[start+i] = temp[i];
    }
}
