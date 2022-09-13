package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 十斐波那契数列 {
    /**
     * 求斐波那契数列第n项
     * @param n
     * @return
     */
    int fib(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        int pre2 = 0;
        int pre1 = 1;
        int result = 0;
        for (int i = 2; i<=n; i++) {
            result = (pre2 + pre1) % 1000000007;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    /**
     * 青蛙一次可以跳一级台阶，也可以跳两级，求跳n级有多少中跳法
     * @param n
     * @return
     */
    int qingwa(int n) {
        if (n<=2) {
            return n;
        }
        int pre2 = 1;
        int pre1 = 2;
        int result = 0;
        for (int i = 3; i<=n; i++) {
            result = (pre2 + pre1)%1000000007;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    /**
     * 如果一只青蛙可以每次跳1级，2级，n级，则到n级台阶有多少中跳法
     * 结论：f(n) = 2^(n-1)
     * @param n
     * @return
     */
    static int qingwa2(int n) {
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 1;
        }
        int res = 1;
        for (int i = 1; i<n; i++) {
            res = (res * 2) % 1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(qingwa2(6));
    }
}
