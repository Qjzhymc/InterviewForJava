package Algorithm4th.剑指offer专项突破版.二分查找;

public class 七十排序数组中只出现一次的数字 {
    int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length/2;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int i = mid * 2;
            if (i < nums.length - 1 && nums[i] != nums[i+1]) {
                if (mid == 0 || nums[i-2] == nums[i-1]) {
                    return nums[i];
                }
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }
}
