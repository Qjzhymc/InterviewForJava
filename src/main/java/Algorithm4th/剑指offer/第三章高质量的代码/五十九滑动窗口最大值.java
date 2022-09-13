package Algorithm4th.剑指offer.第三章高质量的代码;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 五十九滑动窗口最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new PriorityQueue<>((o1, o2)->(o2-o2));
        for (int i = 0; i<k; i++) {
            queue.add(nums[i]);
        }
        res.add(queue.peek());
        for (int i = 0, j = k-1; j<nums.length; i++, j++) {
            queue.remove(nums[i]);
            queue.add(nums[j]);
            res.add(queue.peek());
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
