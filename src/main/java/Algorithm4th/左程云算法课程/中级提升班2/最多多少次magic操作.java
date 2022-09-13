package Algorithm4th.左程云算法课程.中级提升班2;

import java.util.Arrays;
import java.util.HashSet;

public class 最多多少次magic操作 {
    /**
     * 给定一个包含n个整数元素的集合a，一个包含m个整数元素的集合b。
     * 定义magic操作为，从一个集合中取出一个元素，放到另一个集合里，且操作过后每个集合的平均值都大于操作前
     * 注意一下两点：
     * 1）不可以把一个集合的元素取空，这样就没有平均值了
     * 2）值为x的元素从集合b取出放入集合a，但集合a中已经有值为x但元素，则a但平均值不变（因为集合元素不会重复），b的平均值可能会改变
     * 问最多可以进行多少次magic操作
     *
     * 思路：通过分析可以等到结论：应该从平均值大的集合中选出数到平均值小的集合中，选怎样的数呢？应该选 avg(小)<num<avg(大)
     */

    //请保证arr1无重复值，arr2中无重复值，且arr1和arr2肯定有数字
    public int magicTimes(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int i = 0;i<arr1.length;i++) {
            sum1 += (double)arr1[i];
        }
        double sum2 = 0;
        for (int i=0;i<arr2.length;i++) {
            sum2 += (double)arr2[i];
        }
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)){
            return 0;
        }

        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            sumMore = sum1;
            arrLess = arr2;
            sumLess = sum2;
        } else {
            arrMore = arr2;
            sumMore = sum2;
            arrLess = arr1;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for (int num : arrLess) {
            setLess.add(num);
        }

        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
        int ops = 0;
        for (int i =0;i<arrMore.length;i++) {
            double cur = (double) arrMore[i];
            if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize) && !setLess.contains(arrMore[i])) {
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(arrMore[i]); //这个arrMore[i]是不是就是cur
                ops++;
            }
        }
        return ops;
    }

    double avg(double sum, int length) {
        return sum / length;
    }
}
