package Algorithm4th.剑指offer专项突破版;

import java.util.LinkedList;
import java.util.Queue;

public class 滑动窗口的平均值 {

    class MovingAverage{
        Queue<Integer> nums;
        int capacity;
        int sum;
        MovingAverage(int size) {
            nums = new LinkedList<>();
            capacity = size;
        }
        double next(int val) {
            nums.offer(val);
            sum += val;
            if (nums.size() > capacity) {
                sum -= nums.poll();
            }
            return (double)sum / nums.size();
        }
    }

}
