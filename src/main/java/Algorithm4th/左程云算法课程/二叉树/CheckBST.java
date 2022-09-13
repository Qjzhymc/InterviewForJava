package Algorithm4th.左程云算法课程.二叉树;

public class CheckBST {
    /**
     * 判断一颗二叉树是搜索二叉树(左子树节点都比它小，右子树节点都比它大)
     * 思路：用中序遍历，看是否是升序，搜索二叉树都中序遍历一定是升序的
     */

    public static int preValue = Integer.MIN_VALUE;
    public static boolean checkBST(Node head){
        if (head == null){
            return true;
        }
        boolean isLeftBST = checkBST(head.left);
        if (!isLeftBST){
            return false;
        }
        if (head.value < preValue){
            return false;
        } else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }
}
