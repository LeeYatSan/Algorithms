import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = Integer.parseInt(in.nextLine());
            String inputStr = in.nextLine();
            StringBuilder result = new StringBuilder();
//            for(int i = 0; i < N; ++i){
//
//            }

            StringBuilder curr = new StringBuilder();
            boolean flag = false;
            for(int j = 0, k = 0; j < inputStr.length(); ++j, ++k){
                if(k == 0){
                    if(inputStr.charAt(j) == '0')
                        flag = true;
                    else
                        flag = false;
                }
                else if(k == 9){
                    if(flag)
                        curr.reverse();
                    result.append(curr);
                    result.append(" ");
                    k = -1;
                    --j;
                    curr = new StringBuilder();
                }
                else
                    curr.append(inputStr.charAt(j));
            }
            if(flag)
                curr.reverse();
            result.append(curr);
            System.out.println(result.toString().trim());
        }
    }
}
