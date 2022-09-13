package Algorithm4th.剑指offer.第三章高质量的代码;

public class 四十六把数字翻译成字符串 {
    public static int translateNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1;i<n;i++) {
            dp[i+1] = dp[i];
            int number = getNumber(arr[i-1], arr[i]);
            System.out.println(number);
            if (number >= 10 && number <= 25) {
                dp[i+1] += dp[i-1];
            }
        }

        return dp[n];
    }
    static int getNumber(char a, char b) {
        return Integer.parseInt(a + "" + b);
    }

    public static void main(String[] args) {
        System.out.println(translateNum(25));
    }
}
