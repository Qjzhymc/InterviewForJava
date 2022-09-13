package Algorithm4th.剑指offer专项突破版;

import java.util.LinkedList;
import java.util.Queue;

public class 在完全二叉树中添加节点 {

    class CBTInserter{
        Queue<TreeNode> queue;
        TreeNode root;
        CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            queue.offer(root);
            while(queue.peek().left != null && queue.peek().right != null) {
                TreeNode node = queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        int insert(int v) {
            TreeNode parent = queue.peek();
            TreeNode node = new TreeNode(v);

            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
                queue.poll();
                queue.offer(parent.left);
                queue.offer(parent.right);
            }
            return parent.val;
        }

        TreeNode get_root() {
            return this.root;
        }


    }
}
