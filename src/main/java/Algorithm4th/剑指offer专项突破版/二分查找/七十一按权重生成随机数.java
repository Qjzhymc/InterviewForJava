package Algorithm4th.剑指offer专项突破版.二分查找;

import java.util.Random;

public class 七十一按权重生成随机数 {
    int[] sums;
    int total = 0;
    void buildSumArray(int[] w){
        sums = new int[w.length];
        for (int i = 0;i<w.length;i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    int pickIndex(int[] w) {
        buildSumArray(w);
        Random random = new Random();
        int p = random.nextInt(total);
        //找到sums数组中第一个大于p的数
        int left = 0;
        int right = sums.length;
        while(left <= right) {
            int mid = (left + right)/2;
            if (sums[mid] > p) {
                if (mid == 0 || sums[mid-1]<=p) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
