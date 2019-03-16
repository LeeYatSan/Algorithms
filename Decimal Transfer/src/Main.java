/**
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 *
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 *
 * 输入例子1:
 * 0xA
 *
 * 输出例子1:
 * 10
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String hexStr = in.nextLine().toLowerCase();
            int len = hexStr.length();
            int res = 0;
            int index = len-3;
            for(int i = 2; i < len; ++i){
                if(hexStr.charAt(i) >= 'a' && hexStr.charAt(i) <= 'f')
                    res += (hexStr.charAt(i)-'a'+10)*Math.pow(16, index--);
                else
                    res += (hexStr.charAt(i)-'0')*Math.pow(16, index--);
            }
            System.out.println(res);
        }
    }
}
