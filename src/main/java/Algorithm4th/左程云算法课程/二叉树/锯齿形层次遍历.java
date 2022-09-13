package Algorithm4th.左程云算法课程.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 锯齿形层次遍历 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> jiLine = new ArrayList<>();
            while(!s1.isEmpty()) {
                TreeNode cur = s1.pop();
                jiLine.add(cur.val);
                if (cur.left != null) {
                    s2.push(cur.left);
                }
                if (cur.right != null) {
                    s2.push(cur.right);
                }
            }
            res.add(jiLine);

            List<Integer> ouLine = new ArrayList<>();
            while(!s2.isEmpty()) {
                TreeNode cur = s2.pop();
                ouLine.add(cur.val);
                if (cur.right != null) {
                    s1.push(cur.right);
                }
                if (cur.left != null) {
                    s1.push(cur.left);
                }
            }
            res.add(ouLine);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        root.left = nine;
        root.right = twenty;
//        nine.left = five;
//        nine.right = six;
        twenty.left = fifteen;
        twenty.right = seven;
        List<List<Integer>> res = zigzagLevelOrder(root);
        for (List<Integer> line: res){
            for (Integer in: line) {
                System.out.print(in + " ");
            }
            System.out.println();
        }

    }
}
