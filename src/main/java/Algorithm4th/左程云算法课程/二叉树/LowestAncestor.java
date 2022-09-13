package Algorithm4th.左程云算法课程.二叉树;

public class LowestAncestor {
    /**
     * 给定两个二叉树的节点node1，node2，找到他们的最低公共祖先节点
     */
    public static Node lowestAncestor(Node head, Node o1, Node o2){
        if (head == null || head == o1 || head == o2){
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null){
            return head;
        }
        return left != null ? left:right;
    }
}
