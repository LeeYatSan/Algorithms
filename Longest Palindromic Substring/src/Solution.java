////Solution1
//class Solution {
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if(len == 0)
//            return "";
//        int left = 0, right = 1;
//        int tmpLeft = 0, tmpRight = 0;
//        int prelong = 0;
//        while(left < len){
//            while(right < len && s.charAt(left) != s.charAt(right))
//                ++right;
//            if(right == len)
//                --right;
//            if(right-left > prelong && isPalindromic(s, left, right)){
//                tmpLeft = left;
//                tmpRight = right;
//                prelong = tmpRight-tmpLeft;
//            }
//            if(right < len-1)
//                ++right;
//            else{
//                ++left;
//                right = left+1;
//            }
//        }
//        return s.substring(tmpLeft, tmpRight+1);
//    }
//
//    private boolean isPalindromic(String s, int left, int right){
//        while(left < right){
//            if(s.charAt(left++) != s.charAt(right--))
//                return false;
//        }
//        return true;
//    }
//}

//Solution2
public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        // 预处理字符串，避免奇偶问题
        String str = preProcess(s);
        // idx是当前能够向右延伸的最远的回文串中心点，随着迭代而更新
        // max是当前最长回文串在总字符串中所能延伸到的最右端的位置
        // maxIdx是当前已知的最长回文串中心点
        // maxSpan是当前已知的最长回文串向左或向右能延伸的长度
        int idx = 0, max = 0;
        int maxIdx = 0;
        int maxSpan = 0;
        int[] p = new int[str.length()];
        for(int curr = 1; curr < str.length(); curr++){
            // 找出当前下标相对于idx的对称点
            int symmetryOfCurr = 2 * idx - curr;
            // 如果当前已知延伸的最右端大于当前下标，我们可以用对称点的P值，否则记为1等待检查
            p[curr] = max > curr? Math.min(p[symmetryOfCurr], max - curr):1;
            // 检查并更新当前下标为中心的回文串最远延伸的长度
            while((curr+p[curr])<str.length() && str.charAt(curr+p[curr])==str.charAt(curr-p[curr])){
                p[curr]++;
            }
            // 检查并更新当前已知能够延伸最远的回文串信息
            if(curr+p[curr]>max){
                max = p[curr] + curr;
                idx = curr;
            }
            // 检查并更新当前已知的最长回文串信息
            if(p[curr]>maxSpan){
                maxSpan = p[curr];
                maxIdx = curr;
            }
        }
        //去除占位符
        return s.substring((maxIdx-maxSpan)/2,(maxSpan+maxIdx)/2-1);
    }

    private String preProcess(String s){
        // 如ABC,变为$#A#B#C#
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        for(int i = 0; i < s.length(); i++){
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }
}