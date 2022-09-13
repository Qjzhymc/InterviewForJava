package Algorithm4th.剑指offer.第三章高质量的代码;

import java.util.LinkedList;
import java.util.List;

public class 五十七和为s的连续整数序列 {
    public int[][] findContinuousSequence(int target) {
        if (target<3) {
            return new int[][]{{-1, -1}};
        }
        int small = 1;
        int big = 2;
        int mid = (target + 1) / 2;
        int curSum = small + big;
        List<int[]> res = new LinkedList<>();
        while (small < mid) {
            if (curSum == target) {
                res.add(getSeq(small, big));
            }
            while (small < mid && curSum > target) {
                curSum -= small;
                small++;
                if (curSum == target) {
                    res.add(getSeq(small, big));
                }
            }
            big++;
            curSum += big;
        }
        int[][] ret = new int[res.size()][];
        for (int i= 0; i< res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    int[] getSeq(int small, int big) {
        List<Integer> seq = new LinkedList<>();
        for (int i = small; i<=big; i++) {
            seq.add(i);
        }
        return seq.stream().mapToInt(i->i).toArray();
    }
}
