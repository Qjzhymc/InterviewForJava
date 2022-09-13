package Algorithm4th.剑指offer.第三章高质量的代码;

import Algorithm4th.剑指offer专项突破版.ListNode;

public class 十八删除链表的节点 {
    /**
     * 删除给定掉链表节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        if (cur.val == val) {
            return cur.next;
        }
        while(cur.next != null) {
            if (cur.next.val == val) {
                ListNode tmp = cur.next;
                cur.next = cur.next.next;
                tmp.next = null;
                break; //找到之后记得break掉
            }
            cur = cur.next; //记得移动到下一个节点
        }
        return head;
    }

    /**
     * 删除链表中重复的节点
     * @param head
     * @return
     */
    ListNode deleteDepNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == next.val) {
            while(next!=null && next.val == head.val) {
                next = next.next;
            }
            return deleteDepNode(next);
        } else {
            head.next = deleteDepNode(next);
            return head;
        }

    }
}
