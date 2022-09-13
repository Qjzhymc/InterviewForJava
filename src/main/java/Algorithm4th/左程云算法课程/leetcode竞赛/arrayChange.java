package Algorithm4th.左程云算法课程.leetcode竞赛;

import java.util.HashMap;
import java.util.Map;

public class arrayChange {
    public static int[] arrayChange(int[] nums, int[][] operations) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<nums.length;i++) {
            map.put(nums[i], i);
        }

        int times = operations.length;
        for (int j = 0;j<times;j++) {
            int yuan = operations[j][0];
            int xin = operations[j][1];
            int xiabiao = map.get(yuan);
            nums[xiabiao] = xin;
            map.remove(yuan);
            map.put(xin, xiabiao);
        }
        return nums;
    }

    public static void main(String[] args) {
    }
}
