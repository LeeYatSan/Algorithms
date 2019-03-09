public class Main {
    public static void main(String[] args){
        int[][] input = {{6,10}, {-3,3}, {-2,5}, {0,2}};
        int K = 3;
        Solution s = new Solution();
        int[][] res = s.kClosest(input, K);
        for(int i = 0; i < res.length; ++i){
            System.out.println("[" + res[i][0] + ", " + res[i][1] + "]");
        }
    }
}
