package Algorithm4th.剑指offer专项突破版.动态规划;

import java.util.HashMap;
import java.util.Map;

public class 九十三最长斐波拉契数列 {
    int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<A.length;i++) {
            map.put(A[i], i);
        }
        int result = 2;
        int[][] dp = new int[A.length][A.length];
        for (int i = 1;i<A.length;i++) {
            for (int j = 0;j<i;j++) {
                int k = map.getOrDefault(A[i] - A[j], -1);
                dp[i][j] = k >= 0 && k < j ? dp[j][k] + 1 : 2;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result > 2 ? result : 0;

    }
}
