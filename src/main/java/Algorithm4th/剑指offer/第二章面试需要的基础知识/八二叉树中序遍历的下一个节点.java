package Algorithm4th.剑指offer.第二章面试需要的基础知识;


public class 八二叉树中序遍历的下一个节点 {
    class TreeLinkNode{
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        public TreeLinkNode(int v) {
            val = v;
        }
    }
    /**
     * 找到node节点按中序遍历的下一个节点
     *
     * @param root
     * @param node
     * @return
     */
    TreeLinkNode nextNode(TreeLinkNode root, TreeLinkNode node) {
        if (node.right != null) {
            TreeLinkNode cur = node.right;
            while(cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            TreeLinkNode cur = node;
            while(cur.next != null) {
                if (cur.next.left == cur) {
                    return cur.next;
                }
                cur = cur.next;
            }
        }
        return null;
    }
}
