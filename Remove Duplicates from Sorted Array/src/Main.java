public class Main {

    public static void main(String[] args) {
        int[] input = {1,1};
        Solution s = new Solution();
        int len = s.removeDuplicates(input);
        System.out.println("len: "+len);
        for (int i = 0; i < len; i++)
            System.out.print(input[i]);
    }
}
