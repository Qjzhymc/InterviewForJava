package Algorithm4th.左程云算法课程.二叉树;

public class IsFull {
    /**
     * 判断一颗二叉树是满二叉树的套路解法
     */

    public static class Info{
        public int height;
        public int nodes;
        public Info(int h, int n){
            height =h;
            nodes = n;
        }
    }
    public static boolean isFull(Node head){
        if (head == null){
            return false;
        }
        Info data = process(head);
        return data.nodes == (1<<data.height -1);
    }

    public static Info process(Node x){
        if (x==null){
            return new Info(0, 0);
        }
        Info leftData = process(x.left);
        Info rightData  = process(x.right);
        int height = Math.max(leftData.height, rightData.height);
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }
}
