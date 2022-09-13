package Algorithm4th.剑指offer专项突破版.二分查找;

public class 六十九山峰数组的顶部 {
    int peakIndexInMountainArray(int[] nums){
        int left = 1;
        int right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
