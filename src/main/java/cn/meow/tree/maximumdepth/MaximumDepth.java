package cn.meow.tree.maximumdepth;

import cn.meow.tree.been.TreeNode;

public class MaximumDepth {

    /**
     * 递归
     * DFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
