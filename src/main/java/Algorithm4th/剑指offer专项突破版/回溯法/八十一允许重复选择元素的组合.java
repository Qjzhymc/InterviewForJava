package Algorithm4th.剑指offer专项突破版.回溯法;

import java.util.LinkedList;
import java.util.List;

public class 八十一允许重复选择元素的组合 {
    List<List<Integer>> combinationSum(int[] nums, int target) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combine = new LinkedList<>();
        helper(nums, target, 0, combine, result);
        return result;
    }
    void helper(int[] nums, int target, int i, LinkedList<Integer> combine, LinkedList<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(combine));
        } else if (target > 0 && i<nums.length) {
            helper(nums, target, i+1, combine, result);
            combine.add(nums[i]);
            helper(nums, target-nums[i], i, combine, result);
            combine.removeLast();
        }
    }
}
