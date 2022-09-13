//package Algorithm4th.左程云算法课程.基础提升二叉树的Morris遍历;
//
//public class 二进制除法 {
//    /**
//     * a-b 的除法：1.先将b左移到不超过a到地方，说明res在该位置上有一个1；2.然后a更新为a-(b<<i),继续判断，直到b没法右移不超过a。
//     * @param a
//     * @param b
//     * @return
//     */
//    public static int div(int a, int b) {
//        int x = isNeg(a) ? negNum(a) : a;
//        int y = isNeg(b) ? negNum(b) : b;
//        int res = 0;
//        for (int i = 31; i> -1; i = minus(i, 1)) {
//            if ((x >> i) >= y) { //用x右移代替y左移，防止y溢出
//                res = res | (1<<i); //第i位置1
//                x = minus(x, y<<i); // x = x - (y<<i)
//            }
//        }
//        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
//    }
//}
