package Algorithm4th.剑指offer专项突破版.动态规划;

public class 九十二翻转字符 {
    int minFlipsMonoIncr(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][2];
        char ch = s.charAt(0);
        dp[0][0] = ch == '0' ? 0 : 1;
        dp[0][1] = ch == '0' ? 1 : 0;

        for (int i = 1; i<s.length(); i++) {
            char c = s.charAt(i);
            int prev0 = dp[i-1][0];
            int prev1 = dp[i-1][1];
            dp[i][0] = c == '0' ? prev0 : prev0 + 1;
            dp[i][1] = c == '1' ? prev1 : prev1 + 1;
        }
        return Math.min(dp[s.length()-1][0], dp[s.length()-1][1]);
    }
}
