package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 三数组中重复的数字 {
    /**
     * 给定n个数字，每个数字范围在0-(n-1)内，但有重复数字，找出重复数字
     * 方法1：将每个数i放nums[i],使i == nums[i],如果有重复值但话，一定会有多个位置上有同一个值
     * 这个方法会改变原数组的值
     * @param nums
     * @return
     */
    int findDeduplicate(int[] nums) {
        //处理边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //处理无效输入
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length -1) {
                return -1;
            }
        }

        for (int i = 0; i<nums.length; i++) {
//            if (nums[i] == nums[nums[i]]) { //放外面会陷入死循环
//                return nums[i];
//            }
            while(nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }
    private void swap(int[] nums, int i, int j) {
        if (nums[i] != nums[j]) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    /**
     * 方法2：不改变原有数组，用一个辅助数组
     * @param nums
     * @return
     */
    int findDeduplicate2(int[] nums) {
        //边界条件处理同上
        int[] arr = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            if (arr[nums[i]] > 0) {
                return arr[nums[i]];
            }
            arr[nums[i]] = nums[i];
        }
        return -1;
    }


}
