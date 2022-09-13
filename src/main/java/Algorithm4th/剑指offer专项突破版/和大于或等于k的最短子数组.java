package Algorithm4th.剑指offer专项突破版;

public class 和大于或等于k的最短子数组 {
    /**
     * 子数组的和大于等于k的最短子数组
     * @param k
     * @param nums
     * @return
     */
    int minSubArrayLen(int k, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0;right < nums.length;right++) {
            sum += nums[right];
            while(left <= right && sum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
