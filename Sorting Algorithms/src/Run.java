import java.util.Arrays;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        System.out.println("Sorting Algorithms");
        Scanner choice;
        int index = 0;
        while(true){
            System.out.println("Please choose a sorting algorithms:\n1 > Bubble Sort\n2 > Selection Sort\n3 > Insertion Sort\n4 > Shell Sort\n" +
                    "5 > Merge Sort\n6 > Quick Sort\n7 > Heap Sort\n8 > Counting\n9 > Bucket Sort\n10 > Radix Sort");
            choice = new Scanner(System.in);
            if(choice.hasNext())
                index = Integer.valueOf(choice.next());
            if(index < 1 || index > 10)
                System.out.println("No this option!");
            else break;
        }
        int[] arr = (new GenArr()).getArr();
        Sort sort = null;
        switch (index){
            case 1: sort = new BubbleSort(arr); break;
            case 2: sort = new SelectionSort(arr); break;
        }
        sort.coreSort();
        System.out.println("Sorted:");
        System.out.println(Arrays.toString(sort.getArr()));
    }
}