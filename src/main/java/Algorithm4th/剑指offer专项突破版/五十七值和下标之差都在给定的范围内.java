package Algorithm4th.剑指offer专项突破版;

import java.util.TreeSet;

public class 五十七值和下标之差都在给定的范围内 {
    boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0;i<nums.length;i++) {
            long tmp = (long)nums[i];
            Long lower = set.floor(tmp);
            if (lower != null && tmp >= tmp - t) {
                return true;
            }

            Long upper = set.ceiling(tmp);
            if (upper != null && upper <= tmp + t) {
                return true;
            }

            set.add(tmp);
            if (i >= k) {
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
