package Algorithm4th.左程云算法课程.中级提升班1;

public class 加工出等概率返回的函数 {
    /**
     * 假设有一个等概率返回1-5的函数f，请加工出一个可以等概率返回1-7的函数
     */

    //这是给定的等概率返回1-5的函数f
    public static int f() {
        return (int)(Math.random() * 5) + 1;
    }

    //改造成等概率返回0-1的函数
    public static int random01() {
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        return res < 3 ? 0 : 1;  //1,2返回0; 4,5返回1; 3重新做
    }

    //改造成等概率返回1-7
    public static int random17() {
        int res = 0;
        do {
            res = (random01() << 2) + (random01() <<1) + random01();
        } while(res == 7);
        return res + 1; //res是等概率返回0-6，结果加1
    }

    /**
     * 给定一个以p概率返回0，以1-p概率返回1的原函数f，请改造成等概率返回0-1的函数
     *
     * 思路：f函数执行两次，当返回00或11时，重做；
     *      当返回01时，返回0，当返回10时，返回1，这样就保证了等概率返回0和1。
     */
}
