package Algorithm4th.剑指offer第二版2023;

public class 排序数组中两个数字之和 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j++;
            }
        }
        return new int[]{i, j};
    }
}
