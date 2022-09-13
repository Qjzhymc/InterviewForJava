package Algorithm4th.左程云算法课程.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class WideOrder {
    /**
     * 宽度优先遍历 / 层次遍历
     */
    public static void wideOrder(Node head){
        if (head == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value + "");
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node six = new Node(6);
        Node five = new Node(5);
        Node four = new Node(4);
        Node two = new Node(2);
        Node one = new Node(1);
        head.left = six;
        head.right = five;
        six.left = four;
        six.right = two;
        five.left = one;
        wideOrder(head);
    }
}
