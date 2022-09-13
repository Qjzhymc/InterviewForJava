package Algorithm4th.剑指offer专项突破版.排序;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 七十四合并区间 {
    int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)-> (o1[0] - o2[0]));
        List<int[]> merged = new LinkedList<>();
        int i = 0;
        while(i<intervals.length) {
            //第i个区间
            int[] tmp = intervals[i];
            int j = i + 1;
            while(j<intervals.length && intervals[j][0] <= tmp[1]) {
                tmp[1] = Math.max(tmp[1], intervals[j][1]);
                j++;
            }
            merged.add(tmp);
            i=j;
        }
        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }
}
