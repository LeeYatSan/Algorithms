//Solution 1
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; ++i){
            if(target >= matrix[i][0] && target <= matrix[i][col-1]){
                return binarySearch(matrix[i], 0, col-1, target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] currRow, int start, int end, int target){
        if(start >= end){
            if(currRow[end] == target)
                return true;
            else
                return false;
        }
        int mid = (start+end)/2;
        if(target <= currRow[mid])
            return binarySearch(currRow, 0, mid, target);
        else
            return binarySearch(currRow, mid+1, end, target);
    }
}


////Solution 2
//class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix.length == 0 || matrix[0].length == 0)
//            return false;
//        int row = 0;
//        int col = matrix[0].length-1;
//        while(row < matrix.length && col > -1){
//            if(target > matrix[row][col])
//                ++row;
//            else if(target < matrix[row][col])
//                --col;
//            else
//                return true;
//        }
//        return false;
//    }
//}