package Algorithm4th.剑指offer专项突破版;

public class 二叉搜索树查找值 {
    TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while(cur != null) {
            if (cur.val == val) {
                break;
            }
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }
}
