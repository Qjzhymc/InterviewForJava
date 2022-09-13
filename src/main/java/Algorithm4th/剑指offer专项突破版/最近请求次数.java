package Algorithm4th.剑指offer专项突破版;

import java.util.LinkedList;
import java.util.Queue;

public class 最近请求次数 {

    class RecentCounter{
        Queue<Integer> times;
        int windowSize;
        RecentCounter() {
            times = new LinkedList<>();
            windowSize = 3000;
        }
        int ping(int t) {
            times.offer(t);
            while(times.peek() + windowSize < t) {
                times.poll();
            }
            return times.size();
        }
    }
}
