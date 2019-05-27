import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class LCS<T> {

    T[] X;
    T[] Y;
    int[][] c;
    //    int[][] b;
    int m;
    int n;
    int maxI = 0;
    int maxJ = 0;

    LCS(T[] X, T[] Y){
        this.X = X;
        this.Y = Y;
        m = X.length+1;
        n = Y.length+1;
        c = new int[m][n];
    }

    void LCSLength(){

        for(int i = 0; i < n; ++i){
            c[0][i] = 0;
        }
        for(int i = 0; i < m; ++i){
            c[i][0] = 0;
        }

        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(X[i-1] == Y[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                    if(c[i][j] > c[maxI][maxJ]){
                        maxI = i;
                        maxJ = j;
                    }
                }
                else{
                    c[i][j] = 0;
                }
            }
        }

        printLCS();
    }

    private void printLCS(){

        int len = c[maxI][maxJ];
        for(int i = maxI-len; i < maxI; ++i){
            System.out.print(X[i]);
        }
    }

    public static void main(String[] args){

        Character[] X = str2Character("xzyzzyx");
        Character[] Y = str2Character("zxyyzxz");

        long startTime = System.nanoTime();
        (new LCS<Character>(X, Y)).LCSLength();
        long endTime = System.nanoTime();
        System.out.println("\nExecuting time: " + (endTime-startTime));
    }

    private static Character[] str2Character(String input){
        return input.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
    }
}
