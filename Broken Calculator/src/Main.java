import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int x = in.nextInt();
            int y = in.nextInt();

            Solution s = new Solution();
            System.out.println(s.brokenCalc(x, y));
        }
    }
}
