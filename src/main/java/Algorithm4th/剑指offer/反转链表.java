package Algorithm4th.剑指offer;

public class 反转链表 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int v) {
            val = v;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre =null;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur!=null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur != null) {
                next = cur.next;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseList(head);
        while (res!=null) {
            System.out.println(res.val);
            res = res.next;
        }


    }
}
