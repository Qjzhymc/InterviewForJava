package Algorithm4th.剑指offer专项突破版.图;

import java.util.*;

public class 一百一十五重建序列 {
    boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int num : seq) {
                if (num < 1 || num > org.length) {
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<>());
                inDegrees.putIfAbsent(num, 0);
            }


            for (int i = 0; i<seq.size()-1; i++) {
                int num1 = seq.get(i);
                int num2 = seq.get(i+1);
                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    inDegrees.put(num2, inDegrees.get(num2) + 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int num : inDegrees.keySet()) {
            if (inDegrees.get(num) == 0) {
                queue.add(num);
            }
        }

        List<Integer> built = new LinkedList<>();
        while (queue.size() == 1) {
            int num = queue.remove();
            built.add(num);
            for (int next : graph.get(num)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        int[] result = built.stream().mapToInt(i->i).toArray();
        return Arrays.equals(result, org);
    }
}
