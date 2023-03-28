package Algorithm4th.剑指offer第二版2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 数组中和为0的3个数字 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
            // 这里不要用for循环，应该用for循环不好控制i的增加。
            int i = 0;
            while (i < nums.length - 2) {
                twoSum(nums, i, result);
                int tmp = nums[i];
                while (i < nums.length -2 && nums[i] == tmp) {
                    i++;
                }
            }
        }
        return result;
    }
    public static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                //只有出现符合条件的三元组时，才判断跳过重复值
                int tmp = nums[j];
                while (j<nums.length && tmp == nums[j]) {
                    j++;
                }
            }
            // 如果不符合条件就不用判断跳过相同值了
            else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}
