import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int row = in.nextInt();
            int col = in.nextInt();
            int max = 1;
            if(row < 1 || col < 1){
                System.out.println(0);
                continue;
            }
            ++row;
            ++col;
            int[][]grid = new int[row][col];
            for(int i = 0; i < col; ++i)
                grid[0][i] = 1;
            for(int i = 0; i < row; ++i)
                grid[i][0] = 1;
            for(int i = 1; i < row; ++i){
                for(int j = 1; j < col; ++j){
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                    max = max < grid[i][j] ? grid[i][j] : max;
                }
            }
            System.out.println(max);
        }
    }
}
