import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

public class FloydShortestPath {

    int[][] matrix;
    final static int MAX = 99999999;

    public FloydShortestPath(int[][] matrix) {
        this.matrix = matrix;
    }

    public void getTheShortestPath(){
        int n = matrix.length;
        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    if(matrix[i][j] > matrix[i][k] + matrix[k][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] != MAX){
                    System.out.print(matrix[i][j] + " ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        int n = 16;
        String input = "0 1 5 0 2 3 1 3 1 1 4 3 1 5 6 2 4 8 2 5 7 2 6 6 3 7 6 3 8 8 4 7 3 4 8 5 5 8 3 5 9 3 6 8 8 6 9 4 7 10 2 7 11 2 8 11 1 8 12 2 9 11 3 9 12 3 10 13 3 10 14 5 11 13 5 11 14 2 12 13 6 12 14 6 13 15 4 14 15 3";
//        String input = "1 3 3 2 1 2 3 2 7 4 1 6 3 4 1";
        String[] strings = input.split(" ");
        if(strings.length == 0){
            return;
        }
        int[][] nums = new int[n][n];
        for(int[] row : nums){
            Arrays.fill(row, MAX);
        }
        for(int i = 0; i < n; ++i){
            nums[i][i] = 0;
        }
        for (int i = 0; i < strings.length;) {
            int a = Integer.parseInt(strings[i++]);
            int b = Integer.parseInt(strings[i++]);
            int c = Integer.parseInt(strings[i++]);
            nums[a][b] = c;
            nums[b][a] = c;
        }
//        for(int i = 0; i < n; ++i){
//            for(int j = 0; j < n; ++j){
//                System.out.print(nums[i][j] + " ");
//            }
//            System.out.println();
//        }
        long startTime = System.nanoTime();
        (new FloydShortestPath(nums)).getTheShortestPath();
        long endTime = System.nanoTime();
        System.out.println("Executing Time: " + (endTime-startTime));
    }
}
