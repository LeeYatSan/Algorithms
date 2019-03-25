import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String sentence = in.nextLine();
            String regx = "[^a-zA-Z]+";
            Pattern pattern = Pattern.compile(regx);
            Matcher matcher = pattern.matcher(sentence);
            sentence = matcher.replaceAll(" ");
            String[] words = sentence.split(" ");
            Collections.reverse(Arrays.asList(words));
            StringBuilder stringBuilder = new StringBuilder();
            for(String str : words){
                stringBuilder.append(str);
                stringBuilder.append(" ");
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }
}
