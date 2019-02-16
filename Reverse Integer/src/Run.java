import java.util.Random;

public class Run {

    public static void main(String[] args) {
        Solution s = new Solution();
        Random random = new Random();
        int input = random.nextInt();
        System.out.println("Input: " + input);
        System.out.println(s.reverse(input));

        int num = 907654321;
        System.out.println("1："+Integer.toHexString(num));
        System.out.println("2："+Long.toHexString(num * 16L));
        System.out.println("3："+num * 16L);
        System.out.println("4："+(int)((num * 16L) & 0xffffffff));
        System.out.println("5："+num * 16);
    }
}
