package Algorithm4th.剑指offer专项突破版.动态规划;

public class 九十四最少回文分割 {
    int minCut(String s) {
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0;i<len; i++) {
            for (int j = 0;j<=i;j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (ch1 == ch2 && (j>=i-1 || isPal[j+1][i-1])) {
                    isPal[j][i] = true;
                }
            }
        }

        int[] dp = new int[len];
        for (int i = 0;i<len;i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 1;j<=i;j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j-1]+1);
                    }
                }
            }
        }
        return dp[len-1];

    }
}
