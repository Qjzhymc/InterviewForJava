package Algorithm4th.剑指offer;

public class 二叉树的深度 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            val=v;
        }
    }
    public int maxDepth(TreeNode root) {
        //表示该节点给结果贡献了几个值
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
