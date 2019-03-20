import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine().toLowerCase();
            String target = in.nextLine().toLowerCase();
            int res = 0;
            Pattern p = Pattern.compile(target);
            Matcher m = p.matcher(str);
            while (m.find())
                ++res;
            System.out.println(res);
        }
    }
}