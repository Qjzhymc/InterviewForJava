package Algorithm4th.剑指offer专项突破版;

public class 左右两边子数组的和相等 {
    /**
     * 返回下标i，i左边的和等于右边的和
     * @param nums
     * @return
     */
    int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i =0;i<nums.length;i++) {
            sum += nums[i];
            if (sum - nums[i] == total - sum) {
                return i;
            }
        }
        return -1;
    }
}
