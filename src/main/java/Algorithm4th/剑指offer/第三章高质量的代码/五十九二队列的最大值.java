package Algorithm4th.剑指offer.第三章高质量的代码;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 五十九二队列的最大值 {
    class MaxQueue{
        Queue<Integer> queue;
        Deque<Integer> deque;
        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while(!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offer(value);
        }

        public int pop_front() {
            int res = queue.poll();
            if (res == deque.peekFirst()) {
                deque.pollFirst();
            }
            return res;
        }
    }
}
