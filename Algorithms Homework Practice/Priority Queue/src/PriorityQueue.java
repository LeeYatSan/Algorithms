//import java.util.Arrays;
//
//public class PriorityQueue {
//
//    private int[] arr;
//    private int size;
//    private static final int DEFAULT_SIZE = 11;
//
//
//    PriorityQueue(){
//        this.arr = new int[DEFAULT_SIZE];
//    }
//
//    private int getParent(int i){
//        return (i-1)>>>1;
//    }
//
//    private int getLeft(int i){
//        return i<<1+1;
//    }
//
//    private int getRight(int i){
//        return (i+1)<<1;
//    }
//
//    private boolean hasParent(int i){
//        return i > 0;
//    }
//
//    private boolean hasLeft(int i){
//        return getLeft(i) < size;
//    }
//
//    private boolean hasRight(int i){
//        return getRight(i) < size;
//    }
//
//    private int[] resize(){
//        return Arrays.copyOf(arr, arr.length*2);
//    }
//
//    public void push(int e){
//        if(size == arr.length)
//            arr = resize();
//        int currIndex = size++;
//        int parentIndex = currIndex;
//        arr[currIndex] = e;
//        while(hasParent(currIndex)){
//            parentIndex = getParent(parentIndex);
//            int parent = arr[parentIndex];
//            if(e > parent)
//                break;
//            arr[currIndex] = parent;
//            currIndex = parentIndex;
//        }
//        arr[currIndex] = e;
//    }
//
//
////    public int pop(){
////        if(size == 0){
////            throw new IllegalStateException();
////        }
////        int res = arr[0];
////        int last = arr[--size];
////        int currIndex = 0;
////        while(hasLeft(currIndex)){
////            int childIndex = getLeft(currIndex);
////
////            if(hasRight(currIndex) && arr[childIndex] > arr[getRight(currIndex)])
////                childIndex = getRight(currIndex);
////
////            if(arr[childIndex] > last)
////                break;
////
////            arr[currIndex] = arr[childIndex];
////            currIndex = childIndex;
//////
//////            int currTemp = currIndex;
//////            if(hasLeft(currTemp) && getLeft(currTemp) < arr[currTemp]){
//////                swap(getLeft(currTemp), currTemp);
//////                currIndex = getLeft(currTemp);
//////            }
//////            if(hasRight(currTemp) && getRight(currTemp) < arr[currTemp]){
//////                swap(getRight(currTemp), currTemp);
//////                currIndex = getRight(currTemp);
//////            }
////
////        }
////        arr[currIndex] = last;
////        System.out.println("test");
////        return res;
////    }
//
//
//    public int pop(){
//        if(size == 0){
//            throw new IllegalStateException();
//        }
//        int e = arr[0];//取得要移除的元素
//        int x = arr[--size];//找到最后一个元素
//        int i = 0;
//        while( hasLeft(i) ){//如果有左节点，就是还未达到叶子节点
//            int child = getLeft(i);//首先得到左孩子节点的位置
//
//            //如果有右孩子节点且小于左孩子节点
//            //这一步的作用是找到最小的节点，用于后面的比较
//            if(hasRight(i) && arr[getRight(i)] < arr[child]){
//                child = getRight(i);
//            }
//
//            if(arr[child]>x)//如果孩子节点都比最后一个元素要大
//                break;
//            arr[i] = arr[child];
//            i = child;
//        }
//
//        arr[i] = x;
//        return e;
//    }
//
//    private void swap(int indexA, int indexB){
//        arr[indexA] = new Integer[]{arr[indexB], arr[indexB] = arr[indexA]}[0];
//    }
//}


import java.util.Arrays;

public class PriorityQueue {

    private Elem[] arr = new Elem[100];
    private int len;

    private void extend(){
        arr = Arrays.copyOf(arr, arr.length+50);
    }

    public Elem get (int index){
        if(index < 0){
            System.err.println("Parameter value is out of boundary!");
            return null;
        }
        return arr[index];
    }

    private void swap(int indexA, int indexB){
        Elem temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    private void upHeapify(int currIndex){

        int parentIndex = currIndex/2;
        while(currIndex > 0 && arr[currIndex].getKey() > arr[parentIndex].getKey()){
            swap(currIndex, parentIndex);
            currIndex = parentIndex;
            parentIndex = currIndex/2;
        }
    }

    private void downHeapify(int currIndex){

        int left = currIndex*2+1;
        int right= currIndex*2+2;
        int largestIndex = currIndex;
        int parentKey = arr[currIndex].getKey();
        if(len-1 >= left && parentKey < arr[left].getKey()){
            largestIndex = left;
        }
        if(len-1 >= right && arr[largestIndex].getKey() < arr[right].getKey()){
            largestIndex = right;
        }
        if(largestIndex != currIndex){
            swap(currIndex, largestIndex);
            downHeapify(largestIndex);
        }
    }

    public int getMax(){
        return arr[0].getVal();
    }

    public int extractMax(){
        int res = arr[0].getVal();
        swap(0, len-1);
        arr[len-1] = new Elem(0,0);
        len--;
        downHeapify(0);
        return res;
    }

    public void insert(int val, int key){
        if(len == arr.length){
            extend();
        }
        arr[len] = new Elem(val, key);
        upHeapify(len++);
    }

    public void increaseKey(Elem elem, int key){

        if(elem.getKey() > key){
            System.err.println("New key is smaller than current key!");
            return;
        }
        for(int i = 0; i < len; ++i){
            if(arr[i] == elem){
                arr[i].setKey(key);
                upHeapify(i);
                break;
            }
        }
    }

}


class Elem {
    private int val;
    private int key;

    Elem(int val, int key){
        this.val = val;
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
