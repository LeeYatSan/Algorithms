class Solution {
    public int myAtoi(String str) {
        int minus = 0; //positive -> 1; unknown -> 0; negative -> -1
        int result = 0, pre;
        boolean start = false;
        for(int i = 0; i < str.length(); ++i){
            char curr = str.charAt(i);
            if(curr-'0' >= 0 && curr-'0' <= 9){
                start = true;
                if(minus == 0)
                    minus = 1;
                pre = result;
                result = result*10+curr-'0';
                if(result/10 !=  pre)
                    return minus==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            else if(curr == '-' && minus == 0){
                minus = -1;
                start = true;
            }
            else if(curr == '+' && minus == 0){
                minus = 1;
                start = true;
            }
            else if(!start && curr != ' ')
                return 0;
            if(i < str.length()-1 && start){
                char next = str.charAt(i+1);
                if(next-'0' < 0 || next-'0' > 9)
                    return minus*result;
            }
        }
        return minus*result;
    }
}