package cn.meow.tree.balancedbinarytree;

import cn.meow.tree.been.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {

    /**
     * 暴力
     * 广度拿到每个结点, 递归算出每个结点的左右深度
     */
    public boolean isBalanced(TreeNode root) {
        boolean result = true;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                //算出左右子树的深度
                int left = maxDepth(poll.left);
                int right = maxDepth(poll.right);
                //平衡因子 -1 0 1, 才算平衡二叉树
                if (Math.abs(left - right) > 1) {
                    result = false;
                }
            }
        }
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
