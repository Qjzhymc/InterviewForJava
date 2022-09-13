package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 十五二进制中1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
