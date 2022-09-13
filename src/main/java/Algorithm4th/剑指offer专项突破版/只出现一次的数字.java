package Algorithm4th.剑指offer专项突破版;

public class 只出现一次的数字 {
    int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0;i<32;i++) {
                bitSums[i] += (num>>(31-i)) & 1;
            }
        }
        //上面计算之后，就bitSums每一位表示所有数字对应位相加之和
        int result = 0;
        //从右到左一位一位确定是1还是0
        for (int i =0;i<32;i++) {
            result = (result << 1) + bitSums[i] % 3;
        }
        return result;
    }
}
