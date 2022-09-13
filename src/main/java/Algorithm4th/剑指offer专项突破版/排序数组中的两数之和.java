package Algorithm4th.剑指offer专项突破版;

public class 排序数组中的两数之和 {
    int[] twoSum(int[] nums, int target) {
        int i=0;
        int j = nums.length - 1;
        while(i<j && nums[i] + nums[j] != target) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i, j};
    }
}
