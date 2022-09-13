package Algorithm4th.剑指offer.第三章高质量的代码;

import java.util.PriorityQueue;
import java.util.Queue;

public class 四十最小的k个数 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2)-> (o2 - o1));
        for (int i = 0; i<arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        for (int num : maxHeap) {
            System.out.println(num);
        }
        int[] res = new int[maxHeap.size()];
        int size = maxHeap.size();
        for (int i = 0; i<size; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int[] res = getLeastNumbers(arr, 2);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
