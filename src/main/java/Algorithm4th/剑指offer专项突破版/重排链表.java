package Algorithm4th.剑指offer专项突破版;

public class 重排链表 {
    void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        //这样slow就是中间节点
        ListNode tmp = slow.next;
        slow.next = null;
        Link(head, reverseList(tmp), dummy);
    }
    void Link(ListNode node1, ListNode node2, ListNode head) {
        ListNode prev = head;
        while(node1 != null && node2 != null) {
            ListNode tmp = node1.next;
            prev.next = node1;
            node1.next = node2;
            prev=node2;
            node2 = node2.next;
            node1 = tmp;
        }
        if (node1 != null) {
            prev.next = node1;
        }
    }
    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
