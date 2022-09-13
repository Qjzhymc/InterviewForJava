package Algorithm4th.剑指offer专项突破版;

public class 节点值之和最大的路径 {
    int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }
    int dfs(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }
        int[] maxSumLeft = {Integer.MIN_VALUE};
        int left = dfs(node.left, maxSumLeft);//left是经过左子节点一条边的路径之和最大值，maxSumLeft是包含左子节点的路径之和最大值

        int[] maxSumRight = {Integer.MIN_VALUE};
        int right = dfs(node.right, maxSumRight);

        maxSum[0] = Math.max(maxSumLeft[0], maxSumRight[0]);
        maxSum[0] = Math.max(maxSum[0], left + right + node.val);

        return node.val + Math.max(left, right);

    }
}
