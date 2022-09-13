package Algorithm4th.左程云算法课程.二分查找;

public class 分配给商店最多商品的最小值 {
    public static int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int h = Integer.MIN_VALUE;
        for (int q: quantities) {
            if (q >= h) {
                h = q;
            }
        }
        int ans = l;
        while(l < h) {
            int mid = l + (h - l) / 2;
            int sumN = check(n, quantities, mid);
            if (sumN <= n) {
                h=mid;
            } else {
                l = mid + 1;
                ans = l;
            }
        }
        return ans;
    }
    public static int check(int n, int[] quantities, int max) {
        int sum = 0;//以max作为最大值时，所能填满的商店数
        for (int q: quantities) {
            sum += (q + max - 1) / max;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 1;
        int[] quantities = {100000};
        System.out.println(minimizedMaximum(n, quantities));
    }
}
