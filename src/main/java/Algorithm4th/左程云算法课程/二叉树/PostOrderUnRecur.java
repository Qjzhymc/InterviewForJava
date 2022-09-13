package Algorithm4th.左程云算法课程.二叉树;

import java.util.Stack;

public class PostOrderUnRecur {
    /**
     * 非递归后序遍历
     * 1. 用两个栈，一个s1，弹出一个节点，将该节点放入收集栈s2， 先压左节点，再压右节点
     * 2. 依次弹出收集栈s2的节点，打印
     */
    public static void postOrderUncur(Node head){
        if (head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while(!s1.empty()){
                head=s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.println(s2.pop().value + " ");
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
        postOrderUncur(head);
    }
}
