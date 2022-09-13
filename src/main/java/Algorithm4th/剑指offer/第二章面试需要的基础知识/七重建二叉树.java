package Algorithm4th.剑指offer.第二章面试需要的基础知识;

import Algorithm4th.剑指offer专项突破版.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 七重建二叉树 {
    /**
     * 给定前序遍历和中序遍历重建二叉树
     * @param preOrder
     * @param inOrder
     * @return
     */
    TreeNode reconstruct(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i<inOrder.length; i++) {
            numToIndex.put(inOrder[i], i);
        }
        return helper(preOrder, 0, preOrder.length - 1, 0, numToIndex);
    }

    /**
     *
     * @param preOrder
     * @param preLeft  先序左边界
     * @param preRight 先序右边界
     * @param inLeft   中序左边界
     * @param numToIndex
     * @return
     */
    private TreeNode helper(int[] preOrder, int preLeft, int preRight, int inLeft, Map<Integer, Integer> numToIndex) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int inOrderIndex = numToIndex.get(preOrder[preLeft]);
        int leftSize = inOrderIndex - inLeft;
        root.left = helper(preOrder, preLeft+1, preLeft + leftSize, inLeft, numToIndex);
        root.right = helper(preOrder, preLeft + leftSize + 1, preRight, inOrderIndex + 1, numToIndex);
        return root;
    }
}
