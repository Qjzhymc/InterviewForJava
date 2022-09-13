package Algorithm4th.左程云算法课程.中级提升班1;

public class 牛羊吃草谁先吃完 {
    /**
     * 牛和羊每次都只能吃4^n份草，1，4，16，64...
     * 问最后谁先吃完
     * @param n 有n份草
     * @return
     */
    public static String winner1(int n) {
        // 0  1  2 3  4
        // 后 先 后 先 先
        if (n < 5) {
            return (n==0 || n==2) ? "后手" : "先手";
        }
        // n>=5 时
        int base = 1; //先手决定吃的草，先试吃1份，4份，16份，64份...能不能赢
        //先手一个个试，如果怎么吃先手都赢不了，那就后手赢
        while (base <= n) {
            if (winner1(n - base).equals("后手")) {
                return "先手";
            }
            //防止base*4之后溢出
            if (base > n/4) {
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    /**
     * 方法2：根据方法1得到的规律
     * @param n
     * @return
     */
    public static String winner2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i<=50; i++) {
            System.out.println(winner1(i));
        }
    }
}
