package Algorithm4th.左程云算法课程.二叉树;

public class IsBalanceTree {
    /**
     * 判断是否是平衡二叉树(套路解法)
     */
    public static boolean isBalanced(Node head){
        return process(head).isBalanced;
    }
    public static class ReturnType{
        public boolean isBalanced;
        public int height;
        public ReturnType(boolean isB, int hei){
            isBalanced = isB;
            height = hei;
        }
    }
    public static ReturnType process(Node x){
        if (x==null){
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height)+1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }

}
