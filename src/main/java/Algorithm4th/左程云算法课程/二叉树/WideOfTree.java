package Algorithm4th.左程云算法课程.二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class WideOfTree {
    /**
     * 求二叉树的宽度
     * (还不正确，有问题)
     */
    public static int wide(Node head){
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()){
            Node cur = queue.poll();

            int curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel){
                curLevelNodes++;
            } else{
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }

            System.out.println(cur.value + "");
            if (cur.left != null){

                levelMap.put(cur.left, curNodeLevel +1);

                queue.add(cur.left);
            }
            if (cur.right != null){

                levelMap.put(cur.right, curNodeLevel+1);

                queue.add(cur.right);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node six = new Node(6);
        Node five = new Node(5);
        Node four = new Node(4);
        Node two = new Node(2);
        Node one = new Node(1);
        head.left = six;
        head.right = five;
        six.left = four;
        six.right = two;
        five.left = one;
        System.out.println("wide of the tree is :" + wide(head));
    }
}
