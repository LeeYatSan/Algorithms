import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Solution s = new Solution();
            StringBuffer stringBuffer = new StringBuffer(in.nextLine());
            System.out.println(s.replaceSpace(stringBuffer));
        }
    }
}
