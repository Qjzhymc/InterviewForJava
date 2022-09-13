package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 十一选择数组的最小值 {
    /**
     *
     * @param nums
     * @return
     */
    int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left;
        while(nums[left] >= nums[right]) {
            mid = (left+right)/2;
            if (right - left == 1) {
                return nums[right];
            }
            if (nums[left] == nums[right] && nums[right] == nums[mid]) {
                return findMinInOrder(nums, left, right);
            }
            if (nums[left] <= nums[mid]) {
                left = mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return nums[mid];
    }
    int findMinInOrder(int[] nums, int left, int right) {
        int min= nums[left];
        for (int i = left; i<=right; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

}
