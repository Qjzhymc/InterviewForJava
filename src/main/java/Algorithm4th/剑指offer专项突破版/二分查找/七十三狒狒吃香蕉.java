package Algorithm4th.剑指offer专项突破版.二分查找;

public class 七十三狒狒吃香蕉 {
    int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hour = getHour(piles, mid);
            if (hour<=H) {
                if (mid == 1 || getHour(piles, mid-1) > H) {
                    return mid;
                }
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    int getHour(int[] piles, int speed) {
        int hour = 0;
        for (int pile : piles) {
            hour += (pile + speed - 1) / speed;
        }
        return hour;
    }
}
