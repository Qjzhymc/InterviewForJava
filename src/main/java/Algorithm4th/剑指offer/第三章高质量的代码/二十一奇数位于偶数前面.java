package Algorithm4th.剑指offer.第三章高质量的代码;

public class 二十一奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int oddNum = 0;
        for (int num : nums) {
            if (isOdd(num)) {
                oddNum++;
            }
        }
        int i = 0;
        int j = oddNum;
        int[] copy = new int[nums.length];
        for (int num : nums) {
            if (isOdd(num)) {
                copy[i] = num;
                i++;
            } else {
                copy[j] = num;
                j++;
            }
        }
        return copy;
    }
    boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}
