package cn.meow.tree.balancedbinarytree;

import cn.meow.tree.been.TreeNode;

public class BalancedBinaryTree2 {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    /**
     * 自底向上的递归
     * 一直左右子树的递归下去, 到了最底下那层return回去, 自底向上
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return Math.max(left, right) + 1;
    }
}
