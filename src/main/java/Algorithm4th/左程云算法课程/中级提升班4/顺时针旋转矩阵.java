package Algorithm4th.左程云算法课程.中级提升班4;

public class 顺时针旋转矩阵 {
    /**
     * 将整体矩阵顺时针旋转90度
     *
     */
    public void switchMatrix(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length -1;
        while(tR<dR) {
            switchOnce(matrix, tR++, tC++, dR--, dC--);
        }

    }
    public void switchOnce(int[][] m, int a, int b, int c, int d) {
        int tmp = 0;
        for (int i = 0;i<d-b;i++) {
            tmp = m[a][b+i];
            m[a][b+i] = m[c-i] [b];//第一个位置放第四个数
            m[c-i][b] = m[c][d-i];//第四个位置放第三个数
            m[c][d-i] = m[a+i][d];//第三个位置放第二个数
            m[a+i][d] = tmp;//第二个位置放第一个数
        }
    }
}
