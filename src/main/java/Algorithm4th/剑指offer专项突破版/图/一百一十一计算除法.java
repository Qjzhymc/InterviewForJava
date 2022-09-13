package Algorithm4th.剑指offer专项突破版.图;

import java.util.*;

public class 一百一十一计算除法 {
    double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i<queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                result[i] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, from, to, visited);
            }
        }
        return result;
    }
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0;i<equations.size();i++) {
            String val1 = equations.get(i).get(0);
            String val2 = equations.get(i).get(1);
            graph.putIfAbsent(val1, new HashMap<>());
            graph.get(val1).put(val2, values[i]);

            graph.putIfAbsent(val2, new HashMap<>());
            graph.get(val2).put(val1, 1.0 / values[i]);
        }
        return graph;
    }
    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        if (from.equals(to)) {
            return 1;
        }
        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            String next = entry.getKey();
            if(!visited.contains(next)) {
                double nextValue = dfs(graph, next, to, visited);
                if (nextValue > 0) {
                    return entry.getValue() * nextValue;
                }
            }
        }
        visited.remove(from);
        return -1.0;
    }
}
