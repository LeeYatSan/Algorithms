public class Main {
    public static void main(String[] args){
        int[] input = {1,2,0,4,23,56,12,3,4,6};
        int K = 100;
        Solution s = new Solution();
        int[] res = s.getTheTwoValue(input, K);
        for(int curr : res)
            System.out.println(curr);
    }
}
