package Algorithm4th.剑指offer专项突破版.回溯法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 八十三没有重复元素集合的全排列 {
    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums, 0, result);
        return result;
    }
    void helper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> permutation = new LinkedList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            for (int j = i; j<nums.length; j++) {
                swap(nums, i, j);
                helper(nums, i+1, result);
                swap(nums, i, j);
            }
        }
    }
    void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
