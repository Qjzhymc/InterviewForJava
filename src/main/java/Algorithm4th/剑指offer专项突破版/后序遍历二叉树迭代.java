package Algorithm4th.剑指offer专项突破版;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 后序遍历二叉树迭代 {
    List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
            } else {
                stack.pop();
                result.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return  result;
    }
}
