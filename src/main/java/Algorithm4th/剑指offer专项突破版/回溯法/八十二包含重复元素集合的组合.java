package Algorithm4th.剑指offer专项突破版.回溯法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 八十二包含重复元素集合的组合 {
    List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(nums, target, 0, combination, result);
        return result;
    }
    void helper(int[] nums, int target, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
        } else if (target > 0 && i<nums.length) {
            helper(nums, target, getNext(nums, i), combination, result);
            combination.add(nums[i]);
            helper(nums, target-nums[i], i+1, combination, result);
            combination.removeLast();
        }
    }
    int getNext(int[] nums, int i) {
        int next = i;
        while(next < nums.length && nums[next] == nums[i]) {
            next++;
        }
        return next;
    }
}
