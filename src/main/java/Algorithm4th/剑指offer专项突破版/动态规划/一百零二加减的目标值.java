package Algorithm4th.剑指offer专项突破版.动态规划;

public class 一百零二加减的目标值 {
    int findTargetsumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + S)%2 == 1 || sum < S) {
            return 0;
        }
        return subsetSum(nums, (sum+S)/2);
    }
    int subsetSum(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j>=num; j--) {
                dp[j] += dp[j-num];
            }
        }
        return dp[target];
    }
}
