class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(matrix.length == 0)
            return matrix;
        spiralTraverse(0, n-1, 0, n-1, matrix, n, 1);
        return matrix;
    }

    private void spiralTraverse(int rowStart, int rowEnd, int colStart, int colEnd, int[][] matrix, int n, int curr){
        if(rowStart > rowEnd || colStart > colEnd)
            return;
        else if(rowStart == rowEnd && colStart == colEnd)
            matrix[rowStart][colStart] = curr++;
        else{
            int col = colStart, row = rowStart;
            while(col <= colEnd)
                matrix[rowStart][col++] = curr++;
            ++row;
            while(row <= rowEnd)
                matrix[row++][colEnd] = curr++;
            col -= 2;
            while(col >= colStart)
                matrix[rowEnd][col--] = curr++;
            row -= 2;
            while(row > rowStart)
                matrix[row--][colStart] = curr++;
            spiralTraverse(rowStart+1, rowEnd-1, colStart+1, colEnd-1, matrix, n, curr);
        }
    }
}