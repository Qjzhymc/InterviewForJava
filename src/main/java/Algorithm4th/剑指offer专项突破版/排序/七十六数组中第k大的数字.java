package Algorithm4th.剑指offer专项突破版.排序;

import java.util.Random;

public class 七十六数组中第k大的数字 {
    int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while(index != target) {
            if (index > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }
    private int partition(int[] nums, int start, int end) {
        int pivot = new Random().nextInt(end - start + 1) + start;
        swap(nums, pivot, end);
        int small = start - 1;
        for(int j = small; j<end; j++) {
            if (nums[j] < nums[end]) {
                small++;
                swap(nums, small, j);
            }
        }
        small++;
        swap(nums, end, small);
        return small;
    }
    void swap(int[] nums, int index1,int index2) {
        if (index1 != index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}
