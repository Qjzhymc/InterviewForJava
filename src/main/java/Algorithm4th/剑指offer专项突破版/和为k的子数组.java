package Algorithm4th.剑指offer专项突破版;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组 {
    /**
     * 数组中可能还有负数，不能用双指针，应该用前缀和，并用一个哈希表保存每种前缀和出现次数
     * @param nums
     * @param k
     * @return
     */
    int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>(); //表示前i个数字之和为sum出现过多少次
        sumToCount.put(0, 1);
        int sum = 0; //表示前i个数字之和
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum-k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
