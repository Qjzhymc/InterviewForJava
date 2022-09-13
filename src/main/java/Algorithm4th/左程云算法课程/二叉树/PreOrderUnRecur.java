package Algorithm4th.左程云算法课程.二叉树;

import java.util.Stack;

public class PreOrderUnRecur {
    /**
     * 非递归先序遍历
     * 1. 使用栈
     * 2. 头先入栈，栈为空的情况下，弹出栈的一个节点，处理该节点，再将该节点的右节点,左节点分别压栈。
     */
    public static void preOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
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
        preOrderUnRecur(head);
    }
}
