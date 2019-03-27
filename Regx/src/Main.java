import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String input = in.nextLine();
            int[] lowerCase = new int[26];
            int[] upperCase = new int[26];
            Pattern lowerCasePattern = Pattern.compile("[a-z]");
            Pattern upperCasePattern = Pattern.compile("[A-Z]");
            Matcher lowCasematcher = lowerCasePattern.matcher(input);
            Matcher capitalCasematcher = upperCasePattern.matcher(input);
            countCharacter(lowerCase, lowCasematcher);
            countCharacter(upperCase, capitalCasematcher);
            ArrayList<String> results = new ArrayList<>();
            while(stillExist(lowerCase, upperCase)){
                StringBuilder curr = new StringBuilder();
                for(int i = getMaxStart(lowerCase, upperCase); i < 26; ++i){
                    if(lowerCase[i] != 0 && upperCase[i] != 0){
                        curr.append((char)(i+'A'));
                        --upperCase[i];
                        curr.append((char)(i+'a'));
                        --lowerCase[i];
                    }
                    if((i == 25 || (i < 25 && (lowerCase[i+1] == 0 || upperCase[i+1] == 0))) && curr.length() > 0){
                        results.add(curr.toString());
                        curr = new StringBuilder();
                        i = getMaxStart(lowerCase, upperCase)-1;
                    }
                }
            }
            for(String result : results)
                System.out.println(result);
        }
    }

    private static void countCharacter(int[] chars, Matcher matcher){
        while(matcher.find()){
            char curr = matcher.group().toLowerCase().charAt(0);
            ++chars[curr-'a'];
        }
    }

    private static boolean stillExist(int[] lower, int[]upper){
        for(int i = 0; i < 26; ++i){
            if(lower[i]*upper[i] != 0)
                return true;
        }
        return false;
    }

    private static int getMaxStart(int[] lower, int[] upper){
        int maxLen = 0, currLen = 0, maxStart = 0, currStart = -1;
        for(int i = 0; i < 26; ++i){
            if(lower[i]*upper[i] != 0){
                if(currStart == -1)
                    currStart = i;
                ++currLen;
            }
            else{
                if(currLen > maxLen){
                    maxLen = currLen;
                    maxStart = currStart;
                }
                currLen = 0;
                currStart = i+1;
            }
        }
        return maxStart;
    }
}
