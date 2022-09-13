package Algorithm4th.剑指offer专项突破版;

import Algorithm4th.左程云算法课程.链表.回文链表;

public class 删除倒数第k个节点 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head, back = dummy;
        for (int i =0;i<n;i++) {
            front = front.next;
        }
        while(front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
