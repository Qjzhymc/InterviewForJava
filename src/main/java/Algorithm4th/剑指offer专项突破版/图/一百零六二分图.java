package Algorithm4th.剑指offer专项突破版.图;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 一百零六二分图 {
    boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] colors = new int[size];
        Arrays.fill(colors, -1);
        for (int i = 0;i<size;i++) {
            if (colors[i] == -1) {
                boolean res = setColor(graph, colors, i, 0);//对第i个节点所在的图进行涂色
                if (!res) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean setColor(int[][] graph, int[] colors, int i, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = color;
        while(!queue.isEmpty()) {
            int v = queue.remove();
            for (int neighbor : graph[v]) {
                if (colors[neighbor] >= 0) {
                    if (colors[neighbor] == colors[v]) {
                        return false;
                    }
                } else {
                    queue.add(neighbor);
                    colors[neighbor] = 1-colors[v];
                }
            }
        }
        return true;
    }
}
