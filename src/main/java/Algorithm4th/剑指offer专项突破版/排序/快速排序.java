package Algorithm4th.剑指offer专项突破版.排序;

import java.util.Random;

public class 快速排序 {
    int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    void quickSort(int[] nums, int start, int end) {
        if (end > start) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot+1, end);
        }
    }
    int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start +1) + start;
        swap(nums, random, end);
        int small = start - 1;
        for (int i = start; i<end;i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, i, small);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }
    void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}
