import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] maze = new int[N][M];
            for(int i = 0; i < N; i++)
                for(int j = 0; j < M; j++)
                    maze[i][j] = in.nextInt();

            MazeTrace mazeTrace = new MazeTrace(N, M, maze);
            mazeTrace.printMazeTrace();
        }

    }
}

class MazeTrace{
    private int N, M;
    private int[][] maze;
    private ArrayList<Node> bestPath= new ArrayList<>();
    private ArrayList<Node> currPath= new ArrayList<>();

    MazeTrace(int N, int M, int[][] maze){
        this.N = N;
        this.M = M;
        this.maze = maze;
        mazeTrace(0,0);
    }

    private void mazeTrace(int i, int j){
        maze[i][j] = 1;//标注当前点已走
        currPath.add(new Node(i, j));
        if(i == N-1 && j == M-1){
            if(bestPath.isEmpty() || currPath.size() < bestPath.size()){
                bestPath.clear();
                bestPath.addAll(currPath);
            }
        }

        //检查向上走是否可行
        if(i-1 >= 0 && maze[i-1][j] == 0){
            mazeTrace(i-1, j);
        }
        //检查向下走是否可行
        if(i+1 < N && maze[i+1][j] == 0){
            mazeTrace(i+1, j);
        }
        //检查向左走是否可行
        if(j-1 >= 0 && maze[i][j-1] == 0){
            mazeTrace(i, j-1);
        }
        //检查向右走是否可行
        if(j+1 < M && maze[i][j+1] == 0){
            mazeTrace(i, j+1);
        }

        //恢复现场，设置为未走
        maze[i][j] = 0;
        currPath.remove(currPath.size()-1);
    }

    void printMazeTrace(){
        for(Node curr : bestPath){
            System.out.printf("(%d,%d)\n", curr.getRow(), curr.getCol());
        }
    }
}

class Node{
    private int row;
    private int col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }

    int getRow() {
        return row;
    }

    int getCol(){
        return col;
    }
}
