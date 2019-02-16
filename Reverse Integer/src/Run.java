import java.util.Random;

public class Run {

    public static void main(String[] args) {
        Solution s = new Solution();
        Random random = new Random();
        int input = random.nextInt();
        System.out.println("Input: " + input);
        System.out.println(s.reverse(input));
    }
}
