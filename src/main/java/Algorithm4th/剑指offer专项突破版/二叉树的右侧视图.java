package Algorithm4th.剑指offer专项突破版;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右侧视图 {
    List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new LinkedList<>();
        if (root == null) {
            return view;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right!= null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                view.add(node.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return view;
    }
}
