import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] imgs = in.nextLine().toCharArray();
            Arrays.sort(imgs);
            String res = String.copyValueOf(imgs);
            System.out.println(res);
        }
    }
}