////Soliution1
//class Solution {
//    public String reverseWords(String s) {
//        String[] subs = s.split(" ");
//        StringBuilder result = new StringBuilder();
//        for(String sub : subs){
//            sub = reverseWord(sub);
//            result.append(sub);
//            result.append(" ");
//        }
//        result.deleteCharAt(result.length()-1);
//        return result.toString();
//    }
//    private String reverseWord(String sub){
//        int len = sub.length();
//        if(len < 2)
//            return sub;
//        int mid = len/2;
//        String left = sub.substring(0, mid);
//        String right = sub.substring(mid, len);
//        return reverseWord(right)+reverseWord(left);
//    }
//}

//Solution2
class Solution {
    public String reverseWords(String s) {
        String[] subs = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String sub : subs){
            sub = reverseWord(sub);
            result.append(sub);
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
    private String reverseWord(String sub){
        char[] temp = sub.toCharArray();
        for(int head = 0, tail = temp.length-1; head < tail; ++head, --tail)
            swap(temp, head, tail);
        StringBuilder result = new StringBuilder();
        for(char elem : temp)
            result.append(elem);
        return result.toString();
    }
    private void swap(char[]arr, int A, int B){
        arr[A] = new char[]{arr[B], arr[B] = arr[A]}[0];
    }
}


////Solution3
//import java.util.Stack;
//
//class Solution {
//    public String reverseWords(String s) {
//        Stack<Character> temp = new Stack<>();
//        StringBuilder result = new StringBuilder();
//        int pre = 0;
//        for(int i = 0; i < s.length(); ++i){
//            if(s.charAt(i) != ' ')
//                temp.push(s.charAt(i));
//            else{
//                for(int j = pre; j < i; ++j)
//                    result.append(temp.pop());
//                pre = i+1;
//                result.append(' ');
//                temp.clear();
//            }
//        }
//        for(int j = pre; j < s.length(); ++j)
//            result.append(temp.pop());
//        return result.toString();
//    }
//}