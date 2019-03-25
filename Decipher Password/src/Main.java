import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            System.out.println(DecipherPassword(in.nextLine()));
        }
    }

    static private int DecipherPassword(String pwd){
        if(pwd.length() <= 1)
            return pwd.length();
        int idx = 0, max = 0, maxSpan = 0;
        String str = Preprocess(pwd);
        int len = str.length();
        int[] p = new int[len];
        for(int curr = 1; curr < len; ++curr){
            p[curr] = curr < max ? Math.min(p[2*idx-curr], max-curr) : 1;
            while(curr+p[curr] < len && str.charAt(curr+p[curr]) == str.charAt(curr-p[curr]))
                ++p[curr];
            if(curr+p[curr] > max){
                max = curr+p[curr];
                idx = curr;
            }
            if(p[curr] > maxSpan)
                maxSpan = p[curr];
        }
        return maxSpan-1;
    }

    static private String Preprocess(String pwd){
        int len = pwd.length();
        StringBuilder str = new StringBuilder();
        str.append("$");
        for(int i = 0; i < len; ++i){
            str.append("#");
            str.append(pwd.charAt(i));
        }
        str.append("#");
        return str.toString();
    }
}
