public class CountingSort extends Sort {

    CountingSort(int[] arr){
        super(arr);
    }

    public void coreSort(){
        int min = arr[0], max = arr[0];//to keep the min and max value in unsorted array
        for(int i : arr){
            if(i > max)
                max = i;
            if(i < min)
                min = i;
        }
        int bias = 0-min;//the min value may not equals to 0
        int[] couting_arr = new int[max-min+1];//temp-counting array
        for (int i : arr) {//counting the number of each value in unsorted array
            couting_arr[i+bias]++;//i+bias makes sure that the first non-zero element's index is 0
        }
        int i = 0, j = 0;
        while(i < couting_arr.length){
            if(couting_arr[i] != 0){
                arr[j] = i - bias;
                --couting_arr[i];
                ++j;
            }
            else
                i++;
        }
    }
}
