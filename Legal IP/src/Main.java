import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String ip = in.nextLine();
            Pattern pattern = Pattern.compile("[^0-9.]");
            Pattern dot = Pattern.compile("\\.");
            Matcher matcher = pattern.matcher(ip);
            Matcher dotMatcher = dot.matcher(ip);
            int dotCount = 0;
            while(dotMatcher.find())
                ++dotCount;
            if(matcher.find() && dotCount != 3){
                System.out.println("NO");
                continue;
            }
            String[] segments = ip.split("\\.");
            boolean illegal = false;
            if(segments.length != 4)
                illegal = true;
            for(String curr : segments){
                int num = Integer.parseInt(curr);
                if(num < 0 || num > 255){
                    illegal = true;
                    break;
                }
            }
            if(illegal)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
