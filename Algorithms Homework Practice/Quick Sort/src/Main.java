import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        int len = random.nextInt(100);
        int[] input = new int[len];
        for(int i = 0; i < len; ++i){
            input[i] = random.nextInt(1000);
            System.out.print(input[i] + " ");
        }
        QuickSort quickSort = new QuickSort(input);
        int[] res = quickSort.getTheResult();
        System.out.println();
        for(int curr : res)
            System.out.print(curr + " ");
    }
}
