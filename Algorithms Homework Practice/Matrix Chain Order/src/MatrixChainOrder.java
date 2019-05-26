public class MatrixChainOrder {

    private int[] seq;
    private int n;
    private int[][] cost;
    private int[][] pos;

    public MatrixChainOrder(int[] seq) {
        this.seq = seq;
        this.n = seq.length;
        this.cost = new int[n][n];
        this.pos = new int[n][n];
    }

    public void matrixChainOrder(){

        for(int k = 1; k < n; ++k){
            cost[k][k] = 0;
        }
        for(int l = 2; l < n; ++l){
            for(int i = 1; i < n-l+1; ++i){
                int j = i+l-1;
                cost[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j-1; ++k){
                    int currCost = cost[i][k] + cost[k+1][j] + seq[i-1]*seq[k]*seq[j];
                    if(currCost < cost[i][j]){
                        cost[i][j] = currCost;
                        pos[i][j] = k;
                    }
                }
            }
        }
        printOptimalParens(1, n-1);
    }


    private void printOptimalParens(int i, int j){

        if(i == j){
            System.out.print(String.format("A%d", i));
        }
        else{
            System.out.print("(");
            printOptimalParens(i, pos[i][j]);
            printOptimalParens(pos[i][j]+1, j);
            System.out.print(")");
        }
    }
}




//public class MatrixChainOrder {
//
//
//    public static void main(String[] args) {
//        MatrixChainOrder mc = new MatrixChainOrder();
//        int n = 7;
//        int p[] = { 30, 35, 15, 5, 10, 20, 25 };
//        int m[][] = new int[n][n];
//        int s[][] = new int[n][n];
//        mc.matrixChain(p, m, s);
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < n; j++) {
//                System.out.print(m[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < n; j++) {
//                System.out.print(s[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        mc.traceback(s, 1, 6);
//    }
//
//
//
//    public void matrixChain(int[] p, int[][] m, int[][] s) {
//        int n = p.length - 1;
//        System.out.println(n);
//
//        for (int i = 1; i <= n; i++) {
//            m[i][i] = 0;
//        }
//
//        for (int r = 2; r <= n; r++) {
//            for (int i = 1; i <= n - r + 1; i++) {
//                int j = i + r - 1;
//                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
//                s[i][j] = i;
//                for (int k = i + 1; k < j; k++) {
//                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
//                    if (t < m[i][j]) {
//                        m[i][j] = t;
//                        s[i][j] = k;
//                    }
//                }
//            }
//        }
//    }
//
//
//
//    public void traceback(int[][] s, int i, int j) {
//        if (i == j) {
//            return;
//        }
//        traceback(s, i, s[i][j]);
//        traceback(s, s[i][j] + 1, j);
//        System.out.println("Multiply    A" + i + "," + s[i][j] + "and A"
//                + (s[i][j] + 1) + "," + j);
//    }
//
//}

