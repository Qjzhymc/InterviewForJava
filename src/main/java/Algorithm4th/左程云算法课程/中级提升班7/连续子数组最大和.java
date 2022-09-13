package Algorithm4th.左程云算法课程.中级提升班7;


public class 连续子数组最大和 {
    /**
     * 给定一个数组，返回子数组连续最大累加和
     * kadane
     */
    int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur  = 0;
        for (int i =0;i!= arr.length;i++) {
            cur += arr[i];
            max= Math.max(max, cur);
            cur = cur < 0? 0:cur;
        }
        return max;
    }
}
