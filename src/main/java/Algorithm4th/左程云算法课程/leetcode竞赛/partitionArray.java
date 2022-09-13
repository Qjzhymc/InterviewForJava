package Algorithm4th.左程云算法课程.leetcode竞赛;

import java.util.Arrays;

public class partitionArray {

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        return process(nums, 0, k);
    }
    static int process(int[] nums, int i, int k) {
        if (i >= nums.length - 1) {
            return 1;
        }
        int q = nums[i];
        for (int x = i;x < nums.length; x++) {
            if (nums[x] - q <= k) {
                if (x==nums.length-1) {
                    return 1;
                }
            } else {
                i = x;
                break;
            }
        }
        System.out.println("i=" + i);

        return 1 + process(nums, i, k);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int ans = partitionArray(nums, 1);
        System.out.println(ans);
    }
}
