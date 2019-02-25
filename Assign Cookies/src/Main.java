public class Main {
    public static void main(String[] args){
        int[] greedy_factor = {10, 9, 8, 7};
        int[] cooky = {5, 6, 7, 8};
        Solution s = new Solution();
        System.out.println(s.findContentChildren(greedy_factor, cooky));
    }
}
