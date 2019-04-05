import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            String str = in.nextLine();

            if(str.length() < 2){
                System.out.println(str.length());
                return;
            }
            StringBuilder stringBuilder = new StringBuilder(str);
            for(int i = 0; i+1 < stringBuilder.length(); ++i){
                if(stringBuilder.charAt(i) != stringBuilder.charAt(i+1)){
                    stringBuilder.deleteCharAt(i);
                    stringBuilder.deleteCharAt(i);
                    if(i >= 2)
                        i -= 2;
                    else i = 0;
                }
            }
            System.out.println(stringBuilder.length());
        }
    }
}
