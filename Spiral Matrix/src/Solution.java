import java.util.ArrayList;
import java.util.List;

//Solution
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if(matrix.length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        spiralTraverse(0, m-1, 0, n-1, matrix, res);
        return res;
    }

    private void spiralTraverse(int rowStart, int rowEnd, int colStart, int colEnd, int[][] matrix, List<Integer> res){
        if(rowStart > rowEnd || colStart > colEnd)
            return;
        else if(rowStart == rowEnd && colStart != colEnd){
            for(int i = colStart; i <= colEnd; ++i)
                res.add(matrix[rowStart][i]);
        }
        else if(rowStart != rowEnd && colStart == colEnd){
            for(int i = rowStart; i <= rowEnd; ++i)
                res.add(matrix[i][colStart]);
        }
        else if(rowStart == rowEnd && colStart == colEnd){
            res.add(matrix[rowStart][colStart]);
        }
        else{
            int col = colStart, row = rowStart;
            while(col <= colEnd)
                res.add(matrix[rowStart][col++]);
            ++row;
            while(row <= rowEnd)
                res.add(matrix[row++][colEnd]);
            col -= 2;
            while(col >= colStart)
                res.add(matrix[rowEnd][col--]);
            row -= 2;
            while(row > rowStart)
                res.add(matrix[row--][colStart]);
            spiralTraverse(rowStart+1, rowEnd-1, colStart+1, colEnd-1, matrix, res);
        }
    }
}