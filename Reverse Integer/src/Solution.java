class Solution {
    public int reverse(int x) {

        //solution1
        int minus = 1;
        if(x < 0){
            minus = -1;
            x*=minus;
        }
        int result = 0;
        if(x == 0)
            return result;
        else {
            int pri;
            while(x !=0){
                pri = result;
                result = result*10+x%10;
                if((result-x%10)/10 != pri)
                    return 0;
                x/=10;
            }
            return minus*result;
        }


//        //solution2
//        int result = 0;
//        while(x != 0){
//            int pop = x%10;
//            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop > 7)) return 0;
//            if(result < Integer.MIN_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop < -8)) return 0;
//            result = result*10+pop;
//            x/=10;
//        }
//        return result;
    }
}