class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int min_len = strs[0].length();
        int shortest = 0;
        for(int i = 0; i < strs.length; ++i){
            if(strs[i].length() < min_len){
                min_len = strs[i].length();
                shortest = i;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strs[shortest].length(); ++i){
            char curr = strs[shortest].charAt(i);
            for(String str : strs){
                if(str.charAt(i) != curr)
                    return result.toString();
            }
            result.append(curr);
        }
        return result.toString();
    }
}