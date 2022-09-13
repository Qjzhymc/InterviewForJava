package Algorithm4th.剑指offer.第三章高质量的代码;

import java.util.Arrays;
import java.util.Comparator;

public class 四十五把数组排成最小的数 {
    String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] arr = {"ji","jif"};
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num + "");
        }
        return sb.toString();
    }
    int getNum(int a, int b) {
        return Integer.parseInt(a+""+b);
    }
}
