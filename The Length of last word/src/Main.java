import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            String[] temp = str.split(" ");
            String target = temp[temp.length-1].toLowerCase();
            int res = 0;
            int start = target.length()-1;
            for(int i = target.length()-1; i >= 0; --i){
                if(target.charAt(i) < 'a' && target.charAt(i) > 'z'){
                    start = i;
                    break;
                }
                else
                    break;
            }
            for(int i = start; i >= 0; --i){
                if(target.charAt(i) >= 'a' && target.charAt(i) <= 'z')
                    ++res;
                else
                    break;
            }
            System.out.println(res);
        }
    }
}
