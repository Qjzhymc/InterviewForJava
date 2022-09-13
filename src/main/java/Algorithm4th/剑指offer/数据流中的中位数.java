package Algorithm4th.剑指offer;

import java.util.PriorityQueue;

public class 数据流中的中位数 {
    /**
     * 思路：用两个堆，左边大顶堆，右边小顶堆
     * N为偶数时，应该左边多一个数，当num比右边最小当还大时，将右边最小大放左边，num放右边；其余情况num放左边
     * N为奇数时，应该右边多一个数，当num比左边最大当还小时，将左边最大数放右边，num放左边；其余情况num放右边
     */

    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;
    int N;
    /** initialize your data structure here. */
    public 数据流中的中位数() {
        q1 = new PriorityQueue<>();
        q2 = new PriorityQueue<>();
        N = 0;
    }

    public void addNum(int num) {
        if (N==0) {
            q1.add(num);
        } else {
            if (N%2 == 0) {
                if (num>q2.peek()) {
                    int tmp = q2.poll();
                    q1.add(tmp);
                    q2.add(num);
                } else {
                    q1.add(num);
                }
            } else {
                if (num<q1.peek()) {
                    int tmp = q1.poll();
                    q1.add(num);
                    q2.add(tmp);
                } else {
                    q2.add(num);
                }
            }
        }
        N++;
    }

    public double findMedian() {
        if (N%2==0) {
            return (q1.peek() + q2.peek()) / 2;
        } else {
            return q1.peek();
        }
    }
}
