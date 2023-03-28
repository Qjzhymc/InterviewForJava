package Algorithm4th.剑指offer第二版2023;

import java.util.Arrays;

public class countBits {
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = countBits(4);
        System.out.println(Arrays.toString(res));
    }
}
