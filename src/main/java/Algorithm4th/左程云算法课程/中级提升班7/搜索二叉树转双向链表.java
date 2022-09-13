package Algorithm4th.左程云算法课程.中级提升班7;

public class 搜索二叉树转双向链表 {
    /**
     * 双向链表的last指针相当于left指针，next指针相当于二叉树的right指针，
     * 给定一个搜索二叉树，返回对应的双向链表
     */
    //二叉树的节点
    class Node {
        int value;
        Node left; //在双向链表中，left表示last指针，
        Node right; //right表示next指针
        Node(int v) {
            value =v;
        }
    }
    //转化成双向链表的头和尾
    class Info{
        Node start;
        Node end;
        Info(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }
    //将二叉树转为双向链表
    Info process(Node x) {
        if (x == null) {
            return new Info(null, null);
        }
        Info leftHeadEnd = process(x.left);
        Info rightHeadEnd = process(x.right);
        if (leftHeadEnd.end != null) {
            leftHeadEnd.end.right = x;
        }
        x.left = leftHeadEnd.end;
        x.right = rightHeadEnd.start;
        if (rightHeadEnd.start != null) {
            rightHeadEnd.start.left = x;
        }
        return new Info(leftHeadEnd.start != null ? leftHeadEnd.start:x,
                rightHeadEnd.end != null? rightHeadEnd.end:x);
    }
}
