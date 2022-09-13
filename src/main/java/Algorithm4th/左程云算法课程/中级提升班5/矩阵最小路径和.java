package Algorithm4th.左程云算法课程.中级提升班5;

public class 矩阵最小路径和 {
    /**
     * 给定矩阵，返回从左上角到右下角的最小路径和，每次只能向右或向下
     */
    int minPath(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int[] dp = new int[n];
        dp[0] = matrix[0][0];
        for (int i = 0;i<m;i++) {
            dp[0] = dp[0] + matrix[i][0];
            for (int j = 1;j<n;j++) {
                dp[j] = Math.min(dp[j], dp[j-1]) + matrix[i][j];
            }
        }
        return dp[n-1];
    }
}
