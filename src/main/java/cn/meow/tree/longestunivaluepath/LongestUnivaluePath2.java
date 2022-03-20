package cn.meow.tree.longestunivaluepath;

import cn.meow.tree.been.TreeNode;

public class LongestUnivaluePath2 {

    private int path = 0;

    /**
     * 递归
     * 一开始理解错了, 按相同子树做, 题意是同值路径(路径的意思是一条直线, 不能有分叉, 简单来说就是只能有一个拐点)
     */
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //root左子树的最长同值路径
        int left = dfs(root.left);
        //root右子树的最长同值路径
        int right = dfs(root.right);
        int leftPath = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        int rightPath = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        //记录全局
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
