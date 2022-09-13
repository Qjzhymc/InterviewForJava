//package Algorithm4th;
//
//import java.util.Random;
//
//public class testDidi {
//    static int[] helper(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return new int[]{};
//        }
//        int left = 0;
//        int right = nums.length - 1;
//        int i = 0;
//        while(left <= right && i<nums.length) {
//            if (nums[i] % 3 == 0) {
//                left++;
//            } else if (nums[i] % 3 == 2) {
//                swap(nums, i, right);
//                right--;
//            } else {
//                //中间情况 余数为1的
//                swap(nums, i, left);//有问题
//            }
//            i++;
//        }
//        return nums;
//    }
//    int[] helper2(int[] nums) {
//        qs(nums, 0, nums.length-1);
//
//    }
//    void qs(int[] nums, int start, int end) {
//        if (end > start) {
//            int pivot = partition(nums, start, end);
//            qs(nums, start, pivot);
//            qs(nums, pivot+1, end);
//        }
//    }
//    int partition(int[] nums, int start, int end) {
//        int pivot = new Random().nextInt(end-start);
//        swap(nums, pivot, end);
//
//
//        swap(nums, start, end);
//    }
//    static void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1,2,3,5,6,7,8,9};
//        int[] res = helper(nums);
//        for (int num : nums) {
//            System.out.print(num);
//        }
//    }
//
//}
