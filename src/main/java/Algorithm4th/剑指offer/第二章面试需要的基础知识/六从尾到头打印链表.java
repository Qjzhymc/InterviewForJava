package Algorithm4th.剑指offer.第二章面试需要的基础知识;

import Algorithm4th.剑指offer专项突破版.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 六从尾到头打印链表 {
    /**
     * 从尾到头打印链表
     * 方法1：递归
     * @param head
     * @return
     */
    List<Integer> printNode(ListNode head) {
        List<Integer> res = new LinkedList<>();
        if (head == null) {
            return res;
        }
        helper(head, res);
        return res;
    }
    private void helper(ListNode node, List<Integer> res) {
        if (node == null) {
            return;
        } else {
            helper(node.next, res);
            res.add(node.val);
        }
    }

    /**
     * 方法2： 用栈
     * 用栈更好，用递归时当链表长度过长时，会导致函数调用层级很深，可能导致栈溢出
     * @param head
     * @return
     */
    List<Integer> printNode2(ListNode head) {
        List<Integer> res = new LinkedList<>();
        if (head == null) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
