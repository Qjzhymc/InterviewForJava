package Algorithm4th.剑指offer专项突破版.图;

import java.util.*;

public class 一百零九开密码锁 {
    int openLock(String[] deadends, String target) {
        String init = "0000";
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        if (dead.contains(target) || dead.contains(init)) {
            return -1;
        }
        queue1.offer(init);
        visited.add(init);
        int steps = 0;
        while(!queue1.isEmpty()) {
            String cur = queue1.remove();
            if (cur.equals(target)) {
                return steps;
            }
            List<String> nexts = getNeighbors(cur);
            for (String next : nexts) {
                if (!dead.contains(next) && !visited.contains(next)) {
                    queue2.offer(next);
                    visited.add(next);
                }
            }
            if (queue1.isEmpty()) {
                steps++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }
    private List<String> getNeighbors(String cur) {
        List<String> res = new LinkedList<>();
        for (int i = 0;i<cur.length(); i++) {
            char ch = cur.charAt(i);
            char newChar = ch == '9' ? '0' : (char)(ch + 1);
            StringBuilder builder = new StringBuilder(cur);
            builder.setCharAt(i, newChar);
            res.add(builder.toString());

            char newChar2 = ch == '0' ? '9' : (char)(ch - 1);
            StringBuilder builder2 = new StringBuilder(cur);
            builder2.setCharAt(i, newChar2);
            res.add(builder2.toString());
        }
        return res;
    }
}
