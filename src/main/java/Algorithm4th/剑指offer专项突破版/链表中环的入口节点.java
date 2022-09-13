package Algorithm4th.剑指offer专项突破版;

public class 链表中环的入口节点 {

    //找到快慢指针在环中第相遇节点
    ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while(slow!= null && fast!= null) {
            if (slow==fast) {
                return slow;
            }
            slow =slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        ListNode node = head;
        while(node != inLoop){
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }
}
