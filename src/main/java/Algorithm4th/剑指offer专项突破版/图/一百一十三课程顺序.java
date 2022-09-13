package Algorithm4th.剑指offer专项突破版.图;

import java.util.*;

public class 一百一十三课程顺序 {
    int[] findOrder(int numCources, int[][] prerequiesites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i<numCources; i++) {
            graph.put(i, new LinkedList<>());
        }
        int[] inDegree = new int[numCources]; //每个节点的入度
        for (int[] pre : prerequiesites) {
            int after = pre[0];
            int preview = pre[1];
            graph.get(preview).add(after);
            inDegree[after]++;
        }
        Queue<Integer> queue = new LinkedList<>();//入度为0度节点
        for (int i = 0; i<numCources; i++) {
            if (inDegree[0] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new LinkedList<>();
        while(!queue.isEmpty()) {
            int cource = queue.remove();
            order.add(cource);
            for (int next : graph.get(cource)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return order.size() == numCources ? order.stream().mapToInt(i->i).toArray() : new int[0];

    }
}
