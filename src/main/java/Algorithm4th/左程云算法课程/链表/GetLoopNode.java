package Algorithm4th.左程云算法课程.链表;

public class GetLoopNode {
    /**
     * 判断一个单链表是否有环,有的话，返回入环节点
     *
     */

    static class Node{
        int value;
        Node next;
        Node(int val){
            value=val;
        }
    }
    public static Node getLoopNode(Node head){
        if (head==null || head.next==null || head.next.next==null){
            return null;
        }
        Node n1=head.next;
        Node n2=head.next.next;
        while(n1 != n2){
            if (n2.next==null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while(n1 != n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node second = new Node(5);
        Node third = new Node(6);
        Node fourth =  new Node(9);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        Node loopNode = getLoopNode(head);
        System.out.println(loopNode.value);
    }
}
