package Algorithm4th.剑指offer;

public class 复制复杂链表 {
    static class Node{
        int val;
        Node next;
        Node random;
        Node(int v) {
            val =v;
        }
    }
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while(cur!=null) {
            Node tmpNode = new Node(cur.val);
            tmpNode.next = cur.next;
            cur.next = tmpNode;
            cur = tmpNode.next;
        }

        Node newCur = head;
        while(newCur != null) {
            Node tmpNode = newCur.next;
            if (newCur.random != null) {
                tmpNode.random = newCur.random.next;
            }
            newCur = tmpNode.next;
        }

        Node cur3 = head;
        Node newHead = cur3.next;
        while(cur3.next != null) {
            Node next = cur3.next;
            cur3.next = next.next;
            cur3 = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        Node one = new Node(1);

        head.next = thirteen;
        thirteen.next = eleven;
        eleven.next = ten;
        ten.next = one;

        head.random = null;
        thirteen.random = head;
        eleven.random = one;
        ten.random = eleven;
        one.random = head;

        Node res = copyRandomList(head);
        Node cur = res;

        while(cur!=null) {
            System.out.println(cur.val+", ");
            cur = cur.next;
        }

    }
}
