import java.util.Arrays;

public class GenArr{

    GenArr(){
        genArr();
        System.out.println("Unsorted:\n");
        showArr();
    }

    private static final int num = 100;//the number of the elements in the array
    private int[] arr = new int[num];

    //generate the array
    private void genArr(){
        for(int i = 0; i<num; ++i)
            arr[i] = (int)(Math.random()*100);//generate each element randomly and automatically
    }

    //print out the array
    private void showArr() { System.out.println(Arrays.toString(arr)); }

    //get the array
    public int[] getArr(){return arr;}
}
