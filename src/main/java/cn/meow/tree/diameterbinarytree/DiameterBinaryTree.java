package cn.meow.tree.diameterbinarytree;

import cn.meow.tree.been.TreeNode;

public class DiameterBinaryTree {

    private int result = 0;

    /**
     * 判断是否平衡二叉树的思路
     * 题意: 这条路径可能穿过也可能不穿过根结点
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left + right > result) {
            result = left + right;
        }
        return Math.max(left, right) + 1;
    }
}