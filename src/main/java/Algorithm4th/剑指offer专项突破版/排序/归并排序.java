package Algorithm4th.剑指offer专项突破版.排序;

import java.util.Arrays;

public class 归并排序 {
    //递归版本
    int[] sortArray(int[] nums) {
        int[] dst = new int[nums.length];
        dst = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, dst, 0, nums.length);
        return dst;
    }
    void mergeSort(int[] src, int[] dst, int start, int end) {
        if (start >= end - 1){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(src, dst, start, mid);
        mergeSort(src, dst, mid, end);
        int i = start, j = mid, k = start;
        while(i<mid || j<end) {
            if (j==end || (i<mid && src[i] < src[j])) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }
    }
}
