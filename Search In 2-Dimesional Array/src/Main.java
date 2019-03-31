public class Main {
    public static void main(String[] args){
        int[][] input = {{1, 3, 5, 7},{10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 31;
        Solution s = new Solution();
        System.out.println(s.searchMatrix(input, target));
    }
}
