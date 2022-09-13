package Algorithm4th.剑指offer专项突破版;

public class 两个链表的第一个重合节点 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2) {
            p1 = p1.next == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;
        }
        return p1;
    }
}
