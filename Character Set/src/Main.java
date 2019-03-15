/**
 * 输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 *
 * 输入例子1:
 * abcqweracb
 *
 * 输出例子1:
 * abcqwer
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.next();
            StringBuilder res = new StringBuilder();
            int currLen = 0;
            int len = str.length();
            boolean exist = false;
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < currLen; ++j) {
                    if (str.charAt(i) == res.charAt(j)) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    res.append(str.charAt(i));
                    ++currLen;
                }
                exist = false;
            }
            System.out.println(res.toString());
        }
    }
}
