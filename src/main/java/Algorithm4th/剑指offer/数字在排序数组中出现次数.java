package Algorithm4th.剑指offer;

public class 数字在排序数组中出现次数 {
//    int process(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int l = 0;
//        int h = nums.length -1 ;
//        while(l <= h) {
//            int mid = l + (h-l)/2;
//            if (nums[mid] > target) {
//                h = mid;
//            } else {
//                l = mid;
//            }
//        }
//        int startIndex = -1;
//        if (nums[l] == target) {
//            startIndex = l;
//        } else if (nums[h] == target) {
//            startIndex = h;
//        } else {
//            return 0;
//        }
//
//
//        l = 0;
//        h = nums.length - 1;
//        while(l <= h) {
//            int mid = l + (h-l)/2;
//            if (nums[mid] < target) {
//                l = mid;
//            } else {
//                h = mid;
//            }
//        }
//        int endIndex = -1;
//        if (nums[h] == target) {
//            endIndex = h;
//        } else if (nums[l] == target){
//            endIndex = l;
//        } else {
//            return 0;
//        }
//        return endIndex - startIndex + 1;
//    }
    int process(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length-1;
        if (nums[p1] > target || nums[p2] < target) {
            return 0;
        }
        while(nums[p1] < target) {
            p1++;
        }
        while(nums[p2] > target) {
            p2--;
        }
        return p2-p1+1;
    }
}
