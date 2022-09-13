package Algorithm4th.左程云算法课程.中级提升班5;

public class 咖啡杯问题 {
    /**
     *
     * @param arr 每台咖啡机的制作效率
     * @param N 有N个人需要喝咖啡
     * @param a 只有一台洗机器，洗一个咖啡杯需要a的时间
     * @param b 一个咖啡杯不洗的话，需要b时间挥发也可以变干净
     * @return 返回所有人都喝完且咖啡杯变干净最小需要多少时间
     */
//    int coffee(int[] arr, int N, int a, int b) {
//
//    }

    /**
     *
     * @param drinks
     * @param a 洗咖啡杯一杯的时间
     * @param b 自然挥发的时间
     * @param index 从index开始洗
     * @param washline 洗机器的时间
     * @return
     */
    int process(int[] drinks, int a, int b, int index, int washline) {
        if (index == drinks.length-1) {
            return Math.min(Math.max(washline, drinks[index]) + a, drinks[index]+b);
        }
        //当前咖啡杯放机器洗的洗完时间
        int wash = Math.max(washline, drinks[index]) + a;
        //洗完剩下所有咖啡杯最早的结束时间
        int next1 = process(drinks, a, b, index+1, wash);
        int p1 = Math.max(wash, next1);

        //自然风干的时间
        int dry = drinks[index] +b;
        int next2 = process(drinks, a, b, index+1, washline);
        int p2 = Math.max(dry, next2);
        return Math.min(p1, p2);
    }
}
