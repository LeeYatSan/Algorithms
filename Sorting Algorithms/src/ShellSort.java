public class ShellSort extends Sort{
    ShellSort(int[] arr){
        super(arr);
    }

    public void coreSort(){
        int gap = arr.length/2;//To simplify, we used Shell Increment
        while(gap > 0){
            for(int unsorted_first = gap; unsorted_first < arr.length; ++unsorted_first){
                int curr = arr[unsorted_first];
                int i = unsorted_first-gap;
                for(; i > -1 && arr[i] > curr; i-=gap){
                    arr[i+gap] = arr[i];
                }
                    arr[i+gap]=curr;
            }
            gap/=2;
        }
    }
}
