package Algorithm4th.剑指offer专项突破版.动态规划;

import java.util.List;

public class 一百三角形中最小路径之和 {
    int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for (int i = 0;i<size;i++) {
            for (int j = 0;j<=i;j++) {
                if (i == 0 && j==0) {
                    dp[i][j] = triangle.get(0).get(0);
                } else if (i> 0 && j==0) {
                    dp[i][j]= dp[i-1][j] + triangle.get(i).get(0);
                } else if (i==j) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0;j<size;j++) {
            result = Math.min(result, dp[size-1][j]);
        }
        return result;
    }
}
