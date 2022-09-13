package Algorithm4th.剑指offer专项突破版.回溯法;

import java.util.LinkedList;
import java.util.List;

public class 七十九所有子集 {
    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null) {
            return result;
        }
        helper(nums, 0, new LinkedList<>(), result);
        return result;
    }

    void helper(int[] nums, int index, LinkedList<Integer> subsets, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new LinkedList<>(subsets));
        } else if (index < nums.length) {
            helper(nums, index+1, subsets, result);
            subsets.add(nums[index]);
            helper(nums, index+1, subsets, result);
            subsets.removeLast();
        }
    }

}
