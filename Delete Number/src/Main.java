/**
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 *
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 *
 * 输入例子1:
 * 8
 *
 * 输出例子1:
 * 6
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static  void main (String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n > 1000)
                n = 1000;
            if(n == 0 || n == 1){
                System.out.println(0);
                continue;
            }
            int[] arr = new int[n];
            int curr = 0;
            int skip = 3;
            int deleteCount = 0;
            Arrays.fill(arr, 1);
            while(deleteCount < n-1){
                while(skip > 0){
                    if(curr == n)
                        curr = 0;
                    if(arr[curr] == 1)
                        --skip;
                    ++curr;
                    if(curr == n)
                        curr = 0;
                }
                if(curr == 0)
                    curr = n-1;
                else
                    --curr;
                arr[curr] = 0;
                ++deleteCount;
                skip = 3;
                ++curr;
            }
            for(curr = 0; curr < n; ++curr)
                if(arr[curr] == 1){
                    System.out.println(curr);
                    break;
                }
        }
    }
}
