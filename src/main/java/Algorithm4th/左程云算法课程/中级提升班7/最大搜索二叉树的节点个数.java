//package Algorithm4th.左程云算法课程.中级提升班7;
//
//public class 最大搜索二叉树的节点个数 {
//    /**
//     * 找到一个二叉树中，最大的搜索二叉子树，返回最大搜索二叉子树的节点个数
//     */
//    class Node{
//        int value;
//        Node left;
//        Node right;
//        Node(int v) {
//            value = v;
//        }
//    }
//    class Info{
//        Node maxBSTHead; //最大搜索子树的头节点
//        boolean isBST;
//        int min;
//        int max;
//        int maxBSTSize;
//        Info(Node head, boolean is, int mi, int ma, int size) {
//            maxBSTHead = head;
//            isBST = is;
//            min = mi;
//            max = ma;
//            maxBSTSize = size;
//        }
//    }
//    Info process(Node x) {
//        if (x == null) {
//            return null;
//        }
//        Info leftInfo = process(x.left);
//        Info rightInfo = process(x.right);
//
//        int min = Math.min(x.value, Math.min(leftInfo.min, rightInfo.min));
//        int max = Math.max(x.value, Math.max(leftInfo.max, rightInfo.max));
//
//
//        return new Info();
//    }
//
//}
