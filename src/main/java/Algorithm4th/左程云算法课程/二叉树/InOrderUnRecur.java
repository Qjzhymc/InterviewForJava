package Algorithm4th.左程云算法课程.二叉树;

import java.util.Stack;

public class InOrderUnRecur {
    /**
     * 非递归中序遍历
     * 每棵子树，整棵子树左边界进栈，依次弹出的过程中，打印，并对弹出节点的右子树重复以上过程
     */
    public static void inOrderRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left; //只要左子树不为空，就一直加左子树的节点入栈
                }else{
                    head = stack.pop();
                    System.out.println(head.value+ " ");
                    head = head.right; //如果左子树为空了，弹出一个节点，对该节点右子树重复以上过程
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
        inOrderRecur(head);
    }


}
