package Algorithm4th.剑指offer专项突破版;

public class 前n个数字二进制形式中1的个数 {
    /**
     * 思路，可以遍历计算每个i的二进制中1的个数，也可以通过result[i] = result[i&(i-1)]+1的关系，O(n)的时间复杂度计算出来
     * @param num
     * @return
     */
    int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for (int i = 1;i<=num;i++) {
            result[i] = result[i&(i-1)] + 1;
        }
        return result;
    }
}
