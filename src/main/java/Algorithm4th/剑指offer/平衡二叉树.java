package Algorithm4th.剑指offer;

public class 平衡二叉树 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            val=v;
        }
    }

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }
    int height(TreeNode node) {
        if (node == null || !isBalanced) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }

}
