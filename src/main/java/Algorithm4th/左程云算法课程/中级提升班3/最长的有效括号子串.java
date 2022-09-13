package Algorithm4th.左程云算法课程.中级提升班3;

public class 最长的有效括号子串 {
    /**
     * 给定由(,)组成的字符串，返回最长的有效括号连续子串
     * leetcode32
     * 思路：这种求连续子串的题，一般都看每个字符作为末尾时的子串情况
     *
     */

    public int maxLength(String s) {
        if (s==null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        int pre = 0;
        int res = 0;
        for (int i=1;i<str.length;i++) {
            if (str[i] ==')') {
                pre = i - dp[i-1] -1;
                if (pre >=0 && str[pre] == '(') {
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
