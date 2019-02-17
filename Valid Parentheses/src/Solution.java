import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        //solution1
//        if(s == null)
//            return true;
//        else {
//            Stack temp1 = new Stack();
//            Stack temp2 = new Stack();
//            for(int i = 0; i < s.length(); ++i){
//                if(s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '{' || s.charAt(i) == '}' || s.charAt(i) == '[' || s.charAt(i) == ']')
//                    temp1.push(s.charAt(i));
//            }
//            if(temp1.size()%2 != 0)
//                return false;
//            while(!temp1.isEmpty()){
//                char curr = (char)temp1.pop();
//                if(curr == ')' || curr == '}' || curr == ']')
//                    temp2.push(curr);
//                else if(!temp2.isEmpty()){
//                    switch (curr){
//                        case '(': if((char)temp2.pop() != ')') return false; else break;
//                        case '{': if((char)temp2.pop() != '}') return false; else break;
//                        case '[': if((char)temp2.pop() != ']') return false; else break;
//                    }
//                }
//                else return false;
//            }
//            if(temp2.isEmpty()) return true;
//            else return false;
//        }

        //solution2
        if (s == null)
            return true;
        else {
            Stack temp = new Stack();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                    temp.push(s.charAt(i));
                else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                    if (temp.isEmpty()) return false;
                    else {
                        switch (s.charAt(i)) {
                            case ')': if ((char) temp.pop() != '(') return false; else break;
                            case '}': if ((char) temp.pop() != '{') return false; else break;
                            case ']': if ((char) temp.pop() != '[') return false; else break;
                        }
                    }
                }
            }
            if(temp.isEmpty()) return true;
            else return false;
        }
    }
}