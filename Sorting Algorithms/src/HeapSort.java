public class HeapSort extends Sort {
    HeapSort(int[] arr){
        super(arr);
    }

    public void coreSort(){
        buildMaxHeap();
        for(int i = arr.length -1; i >= 1; --i){//loop until the length of the sequence is less than 2
            swap(0, i);
            heapify(0, i);
        }
    }

    private void buildMaxHeap(){//build a max heap
        for(int i = arr.length/2-1; i>=0; i--)//build max heap for all non-leaf nodes
            heapify(i, arr.length);
    }

    private void heapify(int curr_index, int size){//to adjust the heap to a max heap
        int left_index = 2*curr_index+1, right_index = 2*curr_index+2;
        int largest_index = curr_index;
        if(left_index < size && arr[left_index ] > arr[largest_index])//to find the largest one among current node and its child nodes
            largest_index = left_index;
        if(right_index <size && arr[right_index] > arr[largest_index])
            largest_index = right_index;
        if(largest_index != curr_index){//if current node is not the largest one, then exchange them
            swap(largest_index, curr_index);//exchange the value of current node and the largest node only, which means that the index of largest node is not changed but its value is not the largest one but current node one instead. In other words, the current node's index is changed to the ex-largest node's index.
            heapify(largest_index, size);//because of the exchange leading to the change of the current node's index, the max heap may be broken, which means we need to re-heapify a new one.
        }
    }
}
