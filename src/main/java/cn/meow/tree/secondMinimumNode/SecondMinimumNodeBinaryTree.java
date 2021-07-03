package cn.meow.tree.secondMinimumNode;

import cn.meow.tree.been.TreeNode;

public class SecondMinimumNodeBinaryTree {

    private int secondNum;

    /**
     * 递归
     * 题意: 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null || root.right == null) {
            return -1;
        }
        secondNum = Math.max(root.left.val, root.right.val);
        depth(root, root.val);
        return secondNum == root.val ? -1 : secondNum;
    }

    private void depth(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val > val) {
            //没被赋予新的值 或者 新的值比它小
            if (secondNum == val || root.val < secondNum) {
                secondNum = root.val;
            }
        }
        if (root.left != null) {
            depth(root.left, val);
        }
        if (root.right != null) {
            depth(root.right, val);
        }
    }
}
