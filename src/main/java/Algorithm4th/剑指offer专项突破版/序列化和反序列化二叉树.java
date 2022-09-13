package Algorithm4th.剑指offer专项突破版;

public class 序列化和反序列化二叉树 {
    //序列化一个二叉树
    String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return String.valueOf(root.val) + "," + leftStr + "," + rightStr;
    }

    //反序列化二叉树
    TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        int[] i = {0};
        return dfs(nodeStrs, i);
    }
    private TreeNode dfs(String[] strs, int[] i) {
        String str = strs[i[0]];
        i[0]++;
        if (str.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(strs, i);
        node.right = dfs(strs, i);
        return node;
    }

}
