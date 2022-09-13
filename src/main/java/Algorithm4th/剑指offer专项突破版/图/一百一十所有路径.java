package Algorithm4th.剑指offer专项突破版.图;

import java.util.LinkedList;
import java.util.List;

public class 一百一十所有路径 {
    /**
     * 给定有向无环图，计算从0节点到n-1节点到路径条数
     * @param graph
     * @return
     */
    List<List<Integer>> allPathSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        dfs(0, graph, path, result);
        return result;
    }
    private void dfs(int source, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        path.add(source);
        if (source == graph.length - 1) {
            result.add(new LinkedList<>(path));
        } else {
            for (int next : graph[source]) {
                dfs(next, graph, path, result);
            }
        }
        path.remove(path.size() - 1);
    }
}
