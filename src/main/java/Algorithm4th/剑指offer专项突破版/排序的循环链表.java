package Algorithm4th.剑指offer专项突破版;

public class 排序的循环链表 {
    class Node {
        int val;
        Node next;
        Node(int v) {
            val = v;
        }
    }
    Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            node.next = node;
        } else if (head.next == null) {
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }
    void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;
        while(!(cur.val <= node.val && next.val >= node.val) || next != head) {
            cur = next;
            next = next.next;
            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }
        //如果终止的时候是因为找到了中间点
        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;
        } else {
            //如果一直都没找到中间点，那么插在最小点和最大点中间
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}
