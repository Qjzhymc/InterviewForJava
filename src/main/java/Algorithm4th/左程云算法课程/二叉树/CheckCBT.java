package Algorithm4th.左程云算法课程.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckCBT {
    /**
     * 判断一颗二叉树是完全二叉树
     * 思路：层次遍历一棵树，遍历每一个节点过程中，1.如果出现一个节点有右子节点但没有左子节点，则不是完全二叉树；
     * 2.在条件1不违规的情况下，如果遇到第一个左右子节点不全，则接下来的所有节点都是叶子节点
     */
    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ( (leaf && (l!=null || r!=null))  ||  (l==null && r!=null)){
                return false;
            }
            if (l != null){
                queue.add(l);
            }
            if (r!=null){
                queue.add(r);
            }
            if (l==null || r==null){
                leaf = true;
            }
        }
        return true;
    }
}
