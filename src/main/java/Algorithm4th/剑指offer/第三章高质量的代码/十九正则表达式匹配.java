package Algorithm4th.剑指offer.第三章高质量的代码;

public class 十九正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j = 1;j<=n;j++) {
            if (p.charAt(j-1) == '*') {
                if (j==1) {
                    dp[0][1] = true;
                } else {
                    dp[0][j] = dp[0][j-2];
                }
            }
        }
        for (int i = 1; i<=m; i++) {
            for (int j = 1; j<=n; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2]; //匹配0个
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i][j-1] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        boolean[] arr2 = {true, false};
        System.out.println(arr2[-1]);
    }
}
