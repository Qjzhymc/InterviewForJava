package Algorithm4th.左程云算法课程.链表;

import java.util.Stack;

public class 回文链表 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static boolean isPalindrome(ListNode head) {
        //1.先找到中间节点
        ListNode i = head;
        ListNode j = head;
        Stack<ListNode> s = new Stack<>();
        s.push(head);
        while(j.next != null && j.next.next!=null){
            i=i.next;
            s.push(i);
            j=j.next.next;
        }
        //链表为偶数长
        if(j.next != null){
            i = i.next;
        } else {
            i = i.next;
            s.pop();
        }
        while(i != null) {
            if(i.val != s.pop().val) {
                return false;
            }
            i=i.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(2);
        ListNode six = new ListNode(2);
        ListNode seven = new ListNode(2);
        ListNode eight = new ListNode(3);
        ListNode nine = new ListNode(2);
        ListNode ten = new ListNode(1);
        head.next = second;
        second.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;
        System.out.println(isPalindrome(head));


    }
}
