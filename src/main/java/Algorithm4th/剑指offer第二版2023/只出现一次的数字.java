package Algorithm4th.剑指offer第二版2023;



public class 只出现一次的数字 {
    public static int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bitSums[j] += (nums[i] >> (31-j)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i< 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,100};
        System.out.println(singleNumber(nums));
    }
}
