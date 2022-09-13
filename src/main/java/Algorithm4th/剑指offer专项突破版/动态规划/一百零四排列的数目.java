package Algorithm4th.剑指offer专项突破版.动态规划;

public class 一百零四排列的数目 {
    int permutationSum(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1;i<=target;i++) {
            for (int num : nums) {
                if (i>=num) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
