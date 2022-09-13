package Algorithm4th.剑指offer专项突破版;

public class 展平多级双向链表 {
    class Node{
        int val;
        Node next;
        Node prev;
        Node child;
        Node(int v) {
            val = v;
        }
    }
    Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }
    Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while(node != null) {
            Node next = node.next;
            if (node.child != null) {
                Node child = node.child;
                Node childTail = flattenGetTail(child);

                node.child = null;

                node.next = child;
                child.prev = node;

                childTail.next = next;
                if (next !=null) {
                    next.prev = childTail;
                }
                tail = childTail;
            } else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }
}
