package Algorithm4th.剑指offer专项突破版;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 数组中和为0的三个数 {
    List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
            int i = 0;
            while(i<nums.length -2) {
                twoSum(nums, i, result);
                int tmp = nums[i];
                while(i<nums.length && tmp == nums[i]) {
                    i++;
                }
            }
        }
        return result;
    }
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int j = i+1;
        int k = nums.length - 1;
        while(j<k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int tmp = nums[j];
                while(j<nums.length && nums[j] == tmp) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}
