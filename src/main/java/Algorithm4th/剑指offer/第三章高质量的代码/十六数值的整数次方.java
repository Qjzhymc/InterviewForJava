package Algorithm4th.剑指offer.第三章高质量的代码;

public class 十六数值的整数次方 {
    public double myPow(double x, int n) {
        boolean isNeg = false;
        if (n<0) {
            n = -n;
            isNeg = true;
        }
        double res = helper(x, n);
        return isNeg ? 1.0/res : res;
    }
    double helper(double x, int n) {
        if (x == 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = helper(x, n/2);
        res = res * res;
        if ((n&1) == 1) {
            res = res * x;
        }
        return res;
    }
}
