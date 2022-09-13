package Algorithm4th.左程云算法课程.中级提升班3;

public class 根到叶的最大权值和 {
    /**
     * 给定一个二叉树，要求计算从根节点到叶节点到所有路径中，权值和最大到值是多少
     */

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            this.value = v;
        }
    }


    //方法1
    public int maxSum = Integer.MIN_VALUE;
    public int maxPath(Node head) {
        p(head, 0);
        return maxSum;
    }

    public void p(Node node, int pre) {
        if (node.left == null && node.right == null) {
            maxSum = Math.max(maxSum, pre+node.value);
        }
        if (node.left != null) {
            p(node.left, pre+node.value);
        }
        if (node.right != null) {
            p(node.right, pre+node.value);
        }

    }
}
