package Algorithm4th.左程云算法课程.中级提升班3;

public class 数字组成的字母组合总数 {
    /**
     * 假设1对应a，2对应b...26对应z，给定一个num整数，返回能表示的字符串总数
     */
    public int convertWays(int num) {
        if (num <= 0) {
            return 0;
        }
        return process(String.valueOf(num).toCharArray(), 0);
    }
    public int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }

        int res = process(str, index+1);
        if (index == str.length-1){ //当index为最后一位时，只有index自己组成的情况
            return res;
        }
        //当index不是最后一位时，index自己组成当情况 加上 index和index+1一起组成的情况
        if ((str[index]-'0')*10+(str[index+1]-'0') < 27) {
            res = res + process(str, index+2);
        }
        return res;
    }

    //方法2，动态规划版本
    public int numWays(int num) {
        if (num<=0){
            return 0;
        }
        char[] str = String.valueOf(num).toCharArray();
        int N = str.length;
        int[] dp = new int[N+1];
        dp[N] = 1;
        dp[N-1] = str[N-1] == '0' ? 0:1;
        for (int i=N-2;i>=0;i--) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i+1]
                        + (((str[i]-'0')*10 + str[i+1]) < 27 ? dp[i+2] : 0);
            }
        }
        return dp[0];
    }
}
