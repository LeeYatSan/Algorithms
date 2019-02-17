public class Main {

    public static void main(String[] args) {
        String input = "{[a*(b+c)/(f-e}]h}";
        Solution s = new Solution();
        System.out.println(s.isValid(input));
    }
}
