public abstract class Sort {

    protected int[] arr;


    Sort(int[] arr){
        this.arr = arr;
    }

    //swap the value of two specific elements in the array
    protected void swap(int index_a, int index_b){
        arr[index_a] = new Integer[]{arr[index_b], arr[index_b] = arr[index_a]}[0];
    }

    //the core sorting algorithms
    public void coreSort(){}

    public int[] getArr(){return arr;}
}
