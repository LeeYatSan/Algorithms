import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        Random random = new Random();
//        int input = random.nextInt();
        int input = 10;
        System.out.println("Input: " + input);
        System.out.println(s.isPalindrome(input));
    }
}
