package Algorithm4th.剑指offer专项突破版.图;

import java.util.*;

public class 一百一十九最长连续序列 {
    int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        while(!set.isEmpty()) {
            Iterator<Integer> iter = set.iterator();
            longest = Math.max(longest, bfs(set, iter.next()));
        }
        return longest;
    }
    int bfs(Set<Integer> set, int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        set.remove(num);
        int length = 1;
        while(!queue.isEmpty()) {
            int i = queue.poll();
            int[] neightbors = new int[]{i-1, i+1};
            for (int neighbor : neightbors) {
                if (set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.remove(neighbor);
                    length++;
                }
            }
        }
        return length;
    }
}
