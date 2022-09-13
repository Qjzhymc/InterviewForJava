package Algorithm4th.剑指offer专项突破版.二分查找;

public class 六十八查找插入位置 {
    int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid-1] < target) {
                    return mid;
                }
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return nums.length;
    }
}
