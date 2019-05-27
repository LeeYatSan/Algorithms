public class LCS<T> {

    T[] X;
    T[] Y;
    int[][] c;
    int[][] b;
    int m;
    int n;

    LCS(T[] X, T[] Y){
        this.X = X;
        this.Y = Y;
        m = X.length+1;
        n = Y.length+1;
        c = new int[m][n];
        b = new int[m][n];
    }

    void LCSLength(){

        for(int i = 0; i < n; ++i){
            c[0][i] = 0;
        }
        for(int i = 0; i < m; ++i){
            c[i][0] = 0;
        }


        /*
        ↖ => 1
        ↑ => 2
        ← => 3
         */
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(X[i-1] == Y[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 1;
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }

        printLCS(m-1, n-1);
    }

    private void printLCS(int i, int j){
        if(i == 0 || j ==0){
            return;
        }
        if(b[i][j] == 1){
            printLCS(i-1, j-1);
            System.out.print(X[i-1]);
        }
        else if(b[i][j] == 2){
            printLCS(i-1, j);
        }
        else {
            printLCS(i, j-1);
        }
    }
}
