package Algorithm4th.剑指offer专项突破版;

import java.util.List;

public class 最小时间差 {
    int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        boolean[] minuteFlags = new boolean[1440];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int min = Integer.parseInt(t[0])* 60 + Integer.parseInt(t[1]);
            if (minuteFlags[min]) {
                return 0;
            }

            minuteFlags[min] = true;
        }
        return helper(minuteFlags);
    }

    private int helper(boolean[] minuteFlags) {
        int minDiff = minuteFlags.length - 1;
        int prev = -1;
        int first = minuteFlags.length - 1;
        int last = -1;
        for (int i = 0;i<minuteFlags.length; i++) {
            if (minuteFlags[i]) {
                if (prev >= 0) {
                    minDiff = Math.min(i-prev, minDiff);
                }
                prev = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        minDiff = Math.min(minDiff, first + minuteFlags.length - last);
        return minDiff;
    }
}
