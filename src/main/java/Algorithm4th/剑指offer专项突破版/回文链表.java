package Algorithm4th.剑指offer专项突破版;

public class 回文链表 {
    boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        if (fast.next != null) {
            tmp = slow.next.next;
        }
        slow.next = null;
        return equals(head, reverseList(tmp));
    }

    boolean equals(ListNode head1, ListNode head2) {
        while(head1 != null && head2 != null && head1.val == head2.val) {
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null || head2 != null) {
            return false;
        }
        return true;
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
