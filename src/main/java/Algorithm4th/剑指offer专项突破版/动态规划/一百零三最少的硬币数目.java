package Algorithm4th.剑指offer专项突破版.动态规划;

import java.util.Arrays;

public class 一百零三最少的硬币数目 {
    int coinChange(int[] coins, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, target+1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j= target;j>0;j++) {
                for (int k = 1;k*coin <= j;k++) {
                    dp[j] = Math.min(dp[j], dp[j-k*coin] + k);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }
}
