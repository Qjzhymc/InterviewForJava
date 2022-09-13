package Algorithm4th.剑指offer专项突破版.动态规划;

public class 九十七子序列的数目 {
    int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 0;i<s.length();i++) {
            dp[i][0] = 1;
            for (int j = 0;j<=i && j<t.length();j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                } else {
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
