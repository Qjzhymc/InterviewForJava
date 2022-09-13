package Algorithm4th.左程云算法课程.图;

import java.util.*;

public class SortedTopology {
    /**
     * 返回一个有向图的拓扑排序
     */

    public static List<Node> sortedTopology(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInNodes = new LinkedList<>();
        for (Node node: graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroInNodes.add(node);
            }
        }
        //拓扑排序的结果
        List<Node> result = new ArrayList<>();
        while (!zeroInNodes.isEmpty()){
            Node cur = zeroInNodes.poll();
            result.add(cur);
            for (Node next: cur.nexts){
                inMap.put(next, inMap.get(next) -1 );//更新入度减1
                if (inMap.get(next) == 0){
                    result.add(next);
                }
            }
        }
        return result;
    }
}
