package Algorithm4th.左程云算法课程.二叉树;

public class InOrderRecur {
    /**
     * 中序递归遍历
     */
    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value+" ");
        inOrderRecur(head.right);
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
