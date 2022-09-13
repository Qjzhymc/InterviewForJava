package Algorithm4th.剑指offer专项突破版.动态规划;

public class 八十八爬楼梯的最少成本 {
    int minCostClimbingStats(int[] cost) {
        int[] dp = new int[]{cost[0], cost[1]};
        for (int i = 2;i<cost.length;i++) {
            dp[i%2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}
