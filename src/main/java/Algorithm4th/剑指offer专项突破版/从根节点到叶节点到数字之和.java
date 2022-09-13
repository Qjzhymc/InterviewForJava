package Algorithm4th.剑指offer专项突破版;

public class 从根节点到叶节点到数字之和 {
    int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int path) {
        if (node == null) {
            return 0;
        }
        path = path * 10 + node.val;
        if (node.left == null && node.right == null) {
            return path;
        }
        return dfs(node.left, path) + dfs(node.right, path);
    }
}
