package Algorithm4th.左程云算法课程.中级提升班6;

public class 斐波那契数列的logN解法 {
    /**
     *
     */
    int fi(int n) {
        if (n<1) {
            return 0;
        }
        if (n==1 || n==2) {
            return 1;
        }
        int[][] base = {{1,1},
                        {1,0}};
        int[][] res = matrixPower(base, n-2);
        return res[0][0] + res[1][0];
    }
    int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i=0;i<res.length;i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (;p!=0;p>>=1) {
            if ((p&1) != 0) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
        }
        return res;
    }
    //两个矩阵相乘
    int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i =0;i<m1.length;i++) {
            for (int j =0;j<m2[0].length;j++) {
                for (int k=0;k<m2.length;k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
