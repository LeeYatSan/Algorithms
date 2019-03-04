//Solution1: Dynamic Programming: the path number of each grid equals to the sum of the grid upon it and on its left side.
//Dynamic Programming Function: dp[i][j] = dp[i-1][j] + dp[i][j-1]
//Note: We define the start point which is on the left-top of the grids as [0][0], and define the terminal as [n][m] (there are n rows and m colons)
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        int[][] grids = new int[n][m];
        for(int i = 0; i < m; ++i)
            grids[0][i] = 1;
        for(int i = 0; i <n; ++i)
            grids[i][0] = 1;
        for(int i = 1; i < n; ++i)
            for(int j = 1; j < m; ++j)
                grids[i][j] = grids[i-1][j] + grids[i][j-1];
        return grids[n-1][m-1];
    }
}


////Solution2: [Optimized version on storage : O(m*n) -> O(n)]Dynamic Programming: the path number of each grid equals to the sum of the grid upon it and on its left side.
////Dynamic Programming Function: dp[i][j] = dp[i-1][j] + dp[i][j-1]
////Note: We define the start point which is on the left-top of the grids as [0][0], and define the terminal as [n][m] (there are n rows and m colons)
//class Solution {
//    public int uniquePaths(int m, int n) {
//        if(m == 0 && n == 0)
//            return 0;
//       int[] grids = new int[n];
//       grids[0] = 1;
//       for(int i = 0; i < m; ++i)
//           for(int j = 1; j < n; ++j)
//               grids[j] += grids[j-1];
//       return grids[n-1];
//    }
//}