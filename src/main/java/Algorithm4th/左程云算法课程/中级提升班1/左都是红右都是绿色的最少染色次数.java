package Algorithm4th.左程云算法课程.中级提升班1;

public class 左都是红右都是绿色的最少染色次数 {

    /**
     * 方法1：左边都是红色，右边都是绿色，中间有一个边界线，假设边界线在最左边，需要染几个；再假设左边有一个，需要染几个；再假设左边有两个，需要染几个...
     * 复杂度：O(n^2)
     */


    /**
     * 预处理数组方法
     *
     * 方法2：用一个辅助数组A，记录(0,i)范围上有几个绿色；用另一个辅助数组B,记录(i,N-1)范围上有几个红色；
     * 这样每次遍历到边界线到i时，左边A[i]个绿色需要染成红色，右边B[i]个红色需要染成绿色。
     * 时间复杂度:O(n)
     */
    public int minColor(char[] nums) {
        int[] A = new int[]{};
        int[] B = new int[]{};
        int greenNum =0;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i] == 'G') {
                greenNum++;
                A[i] = greenNum;
            }
        }
        int redNum = 0;
        for (int j=nums.length-1;j>=0;j--) {
            if (nums[j] == 'R') {
                redNum++;
                B[j] = redNum;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int L = 0;L<nums.length;L++) {
            int needChange = A[L] + B[L];
            if (needChange<res) {
                res = needChange;
            }
        }
        return res;
    }

}
