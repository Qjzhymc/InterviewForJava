package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 十四剪绳子 {
    public int cuttingRope(int n) {
        if (n==1) {
            return 0;
        }
        if (n==2) {
            return 1;
        }
        if (n==3) {
            return 2;
        }
        int timeOf3 = n/3;
        if (n-timeOf3 == 1) {
            timeOf3--;
        }
        int timeOf2 = (n-timeOf3*3)/2;
        return (int)Math.pow(3, timeOf3) * (int)Math.pow(2, timeOf2);
    }
}
