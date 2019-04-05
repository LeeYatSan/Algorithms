//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//
//        while(in.hasNext()){
//            int n = Integer.parseInt(in.nextLine());
//            String str = in.nextLine();
//
//            if(str.length() < 2){
//                System.out.println(str.length());
//                return;
//            }
//            StringBuilder stringBuilder = new StringBuilder(str);
//            for(int i = 0; i+1 < stringBuilder.length(); ++i){
//                if(stringBuilder.charAt(i) != stringBuilder.charAt(i+1)){
//                    stringBuilder.deleteCharAt(i);
//                    stringBuilder.deleteCharAt(i);
//                    if(i >= 2)
//                        i -= 2;
//                    else i = 0;
//                }
//            }
//            System.out.println(stringBuilder.length());
//        }
//    }
//}


import java.util.Scanner;
import java.util.Stack;

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

            Stack<Character> stack = new Stack<>();

            stack.push(str.charAt(0));

            for(int i = 1; i < str.length(); i++){
                if(!stack.isEmpty() && stack.peek() != str.charAt(i))
                    stack.pop();
                else
                    stack.push(str.charAt(i));
            }
            System.out.println(stack.size());
        }
    }
}
