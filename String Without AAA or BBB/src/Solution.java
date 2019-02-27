////solution1
//class Solution {
//    public String strWithout3a3b(int A, int B) {
//        if(A >= B) return buildStr('a', 'b', A, B);
//        else return buildStr('b', 'a', B, A);
//
//    }
//    private String buildStr(char max, char min, int max_num, int min_num){
//        StringBuilder res = new StringBuilder();
//        int max_div = max_num/2;
//        for(int i = 0; i < max_num; ++i){
//            res.append(max);
//        }
//        if(max_num == 1)
//            return res.append(min).toString();
//        int dynamic_offset = 0;
//        for(int i = 1; i <= max_div && min_num > 0; i++){
//            res.insert(3*i-1, min);
//            --min_num;
//        }
//        if(max_num%2 == 1 && min_num > 0){
//            res.append(min);
//            --min_num;
//        }
//        if(min_num > 0){
//            for(int i = 1; min_num != 1; i++){
//                res.insert(4*i-1, min);
//                --min_num;
//            }
//
//            res.append(min);
//            --min_num;
//        }
//        return res.toString();
//    }
//}

//solution2
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        boolean writeA;
        int len;
        while(A > 0 || B > 0){
            writeA = false;
            len = res.length();
            if(len > 1 && res.charAt(len-1) == res.charAt(len-2)){
                if(res.charAt(len-1) == 'b')
                    writeA = true;
            }
            else {
                if(A > B)
                    writeA = true;
            }
            if(writeA){
                res.append('a');
                --A;
            }
            else {
                res.append('b');
                --B;
            }
        }
        return res.toString();
    }
}