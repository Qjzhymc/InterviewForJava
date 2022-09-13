package Algorithm4th.剑指offer专项突破版;

import java.util.*;

public class 六十一和最小的k个数对 {
    List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> (p2[0]+p2[1]-p1[0]-p1[1]));
        for (int i =0;i<Math.min(nums1.length, k);i++) {
            for (int j= 0;j<Math.min(nums2.length, k);j++) {
                if (maxHeap.size() >= k) {
                    int[] root = maxHeap.peek();
                    if (root[0] + root[1] > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    } else {
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        while(!maxHeap.isEmpty()) {
            int[] vals = maxHeap.poll();
            result.add(Arrays.asList(vals[0], vals[1]));
        }
        return result;
    }
}
