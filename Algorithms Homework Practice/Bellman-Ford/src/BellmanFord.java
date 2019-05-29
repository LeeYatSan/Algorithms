import java.util.Arrays;

public class BellmanFord {

    int[][] weight;
    int[][] distance;
    final static int MAX = 999999;

    public BellmanFord(int[][] matrix) {
        this.weight = matrix;
    }

    public void getTheShortestPath(){
        int n = weight.length;
        distance = new int[n][n];
        for(int[] row : distance){
            Arrays.fill(row, MAX);
        }
        distance[0][0] = 0;
        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    if(distance[i][j] > distance[i][k] + weight[k][j]){
                        distance[i][j] = distance[i][k] + weight[k][j];
                    }
                }
            }
        }
        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    if(distance[i][j] > distance[i][k] + weight[k][j]){
                        System.out.println("Exist minus ring route!");
                        return;
                    }
                }
            }
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(distance[i][j] != MAX){
                    System.out.print(distance[i][j] + " ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args){

        int n = 5;
        String input = "0 1 -1 0 2 3 1 2 3 1 3 2 1 4 2 3 1 1 3 2 5 4 3 -3";
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
        (new BellmanFord(nums)).getTheShortestPath();
        long endTime = System.nanoTime();
        System.out.println("Executing Time: " + (endTime-startTime));
    }
}
