package Algorithm4th.剑指offer专项突破版.动态规划;

public class 一百零一分割等和子集 {
    boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return sunsetSum(nums, sum/2);
    }
    //能否从nums数组中选择若干个数组成和为target
    boolean sunsetSum(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length+1][target+1];

        for (int i =0;i<nums.length+1;i++) {
            dp[i][0] = true;
        }

        for (int i = 1;i<=nums.length;i++) {
            for (int j = 1;j<=target;j++) {
                dp[i][j] = dp[i-1][j];
                if (!dp[i][j] && j>=nums[i-1]) {
                    dp[i][j] = dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
