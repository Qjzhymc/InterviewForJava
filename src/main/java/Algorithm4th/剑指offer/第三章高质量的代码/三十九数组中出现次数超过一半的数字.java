package Algorithm4th.剑指offer.第三章高质量的代码;

public class 三十九数组中出现次数超过一半的数字 {
    static int majority(int[]  nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1;i<nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        System.out.println(majority(new int[]{3,1,4,5,4,5,4}));
    }
}
