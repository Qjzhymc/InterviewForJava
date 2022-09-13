package Algorithm4th.剑指offer专项突破版;

import java.util.Stack;

public class 五十三二叉搜索树的下一个节点 {
    //方法1：
    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean found = false;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (found) {
                break;
            } else if (p == cur) {
                found = true;
            }
            cur = cur.right;
        }
        return cur;
    }
    //方法2
    TreeNode inorderSucessor2(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode result = null;
        while (cur != null) {
            if (cur.val > p.val) {
                result = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return result;
    }
}
