package Algorithm4th.剑指offer专项突破版;

import java.util.Stack;

public class 五十五二叉搜索树迭代器 {
    class BSTIterator{
        TreeNode cur;
        Stack<TreeNode> stack;
        BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }
        boolean hasNext(){
            return cur != null || !stack.isEmpty();
        }
        int next() {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }
    }
}
