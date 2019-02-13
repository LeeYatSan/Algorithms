public class BubbleSort extends Sort{

    BubbleSort(int[] arr){
        super(arr);
    }

    //core algorithms of bubble sort
    public void coreSort() {
        for (int i = 0; i < arr.length - 1; ++i)
            for (int j = 0; j < arr.length - i - 1; ++j)
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
    }
}
