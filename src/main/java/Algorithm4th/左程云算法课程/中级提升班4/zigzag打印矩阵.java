package Algorithm4th.左程云算法课程.中级提升班4;

import java.util.ArrayList;
import java.util.List;

public class zigzag打印矩阵 {
    /**
     * 以zigzag方式打印矩阵
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> zigzag(int[][] matrix) {
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int endR = matrix.length-1;
        int endC = matrix[0].length -1;
        boolean fromUp = false;
        while(ar != endR + 1) {
            printLine(matrix, ar, ac, br, bc, fromUp);
            ar = ac == endC ? ar + 1: ar;
            ac = ac == endC ? ac : ac + 1;
            bc = br == endR ? bc+1: bc;
            br = br == endR ? br:br +1;
            fromUp = !fromUp;
        }
        return res;
    }
    public void printLine(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            //从右上方往左下方打印
            while(tR != dR +1) {
                res.add(m[tR++][tC--]);
            }
        } else {
            //从坐下往右上打印
            while(dR != tR - 1) {
                res.add(m[dR--][dC++]);
            }
        }
    }
}
