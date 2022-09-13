package Algorithm4th.剑指offer专项突破版;

public class 乘积小于k的子数组 {
    int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0;right<nums.length;right++) {
            product *= nums[right];
            while(left<=right && product >= k) {
                product /= nums[left];
                left++;
            }
            count += right >=left ? right-left + 1: 0;
        }
        return count;
    }
}
