package Algorithm4th.剑指offer专项突破版;

import java.util.HashMap;
import java.util.Map;

public class 路径节点值之和 {
    int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, map, 0);
    }
    private int dfs(TreeNode node, int sum, Map<Integer, Integer> map, int path) {
        if (node == null) {
            return 0;
        }
        path += node.val;
        int count = map.getOrDefault(path - sum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);

        count += dfs(node.left, sum, map, path);
        count += dfs(node.right, sum, map, path);

        map.put(path, map.get(path) - 1);
        return count;
    }
}
