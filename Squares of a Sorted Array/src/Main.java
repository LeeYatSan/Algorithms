public class Main {
    public static void main(String[] args){
        int[] input = {-4,-1,0,3,10};
        Solution s = new Solution();
        int[] res  = s.sortedSquares(input);
        for(int i : res)
            System.out.print(i + " ");
    }
}
