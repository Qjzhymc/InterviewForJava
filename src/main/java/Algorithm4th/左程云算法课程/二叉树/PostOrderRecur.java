package Algorithm4th.左程云算法课程.二叉树;

public class PostOrderRecur {
    /**
     * 后序递归遍历二叉树
     *
     */
    public static void postOrderRecur(Node head){
        if (head == null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value + " ");
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
        postOrderRecur(head);
    }
}
