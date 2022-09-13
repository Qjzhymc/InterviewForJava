package Algorithm4th.左程云算法课程.中级提升班4;

import java.util.List;

public class 螺旋打印矩阵 {
    /**
     * 以螺旋方式打印矩阵
     * 思路：给定左上角点和右下角点，打印这个方框的值...
     *
     */
    List<Integer> res;
    public void print(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR=matrix.length;
        int dC = matrix[0].length;
        while(tR<=dR && tC <= dC) {
            printOneCircle(matrix, tR++, tC++, dR--, dC--);
        }
    }

    //m[a][b]是左上角位置，m[c][d]是右下角位置
    public void printOneCircle(int[][] m, int a, int b, int c, int d) {
        if (a==c) { //在同一行上
            for (int i = b;i<=d;i++) {
                res.add(m[a][i]);
            }
        } else if (b==d) {
            //在同一列上
            for (int i = a;i<=c;i++) {
                res.add(m[i][b]);
            }
        } else {
            int curC = b;
            int curR = a;
            //上面行
            while (curC != d) {
                res.add(m[a][curC]);
                curC++;
            }
            //右边列
            while(curR != c) {
                res.add(m[curR][d]);
                curR++;
            }
            //下边行
            while(curC != b) {
                res.add(m[c][curC]);
                curC--;
            }
            while(curR != a) {
                res.add(m[curR][b]);
                curR--;
            }
        }

    }
}
