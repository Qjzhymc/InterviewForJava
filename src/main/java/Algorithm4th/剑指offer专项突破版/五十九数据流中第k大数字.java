package Algorithm4th.剑指offer专项突破版;

import java.util.PriorityQueue;

public class 五十九数据流中第k大数字 {
    class KthLargest{
        PriorityQueue<Integer> minHeap;
        int size;
        KthLargest(int k, int[] nums) {
            size = k;
            minHeap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }
        int add(int val) {
            if (minHeap.size() < size) {
                minHeap.offer(val);
            } else if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }
}
