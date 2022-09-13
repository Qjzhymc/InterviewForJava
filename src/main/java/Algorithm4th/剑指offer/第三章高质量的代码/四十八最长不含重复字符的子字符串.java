package Algorithm4th.剑指offer.第三章高质量的代码;

import java.util.Arrays;

public class 四十八最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        int[] position = new int[26];
        Arrays.fill(position, -1);
        dp[0] = 1;
        int maxLength = 1;
        position[s.charAt(0) - 'a'] = 0;
        for (int i = 1; i<n; i++) {
            int preIndex = position[s.charAt(i) - 'a'];
            if (preIndex == -1 || i > preIndex + dp[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = i - preIndex;
            }
            maxLength = Math.max(maxLength, dp[i]);
            position[s.charAt(i) - 'a'] = i;
        }
        return maxLength;
    }
}
