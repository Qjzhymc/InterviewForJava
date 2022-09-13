package Algorithm4th.剑指offer专项突破版;

public class 二维子矩阵的数字之和 {

    int[][] sums;
    二维子矩阵的数字之和(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        //直接申请一个多一行一列的数组，方便计算第0行第0列
        sums = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0;i<matrix.length;i++) {
            int rowSum = 0;
            for (int j = 0;j<matrix[0].length;j++) {
                rowSum += matrix[i][j];
                sums[i+1][j+1] = sums[i][j+1] + rowSum;
            }
        }
    }

    /**
     * 给定左上角坐标和右下角坐标，返回组成的子矩阵的和
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row1][col2+1] - sums[row2+1][col1] + sums[row1][col1];
    }
}
