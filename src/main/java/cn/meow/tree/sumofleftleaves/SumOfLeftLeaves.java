package cn.meow.tree.sumofleftleaves;

import cn.meow.tree.been.TreeNode;

public class SumOfLeftLeaves {

    private int sum = 0;

    /**
     * 递归
     * 深度
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        depth(root,false);
        return sum;
    }

    private void depth(TreeNode root,boolean isLeft) {
        if (root == null) {
            return;
        }
        //叶子结点
        if (isLeft && root.left == null && root.right == null) {
            sum += root.val;
        }
        if (root.left != null) {
            depth(root.left,true);
        }
        if (root.right != null) {
            depth(root.right,false);
        }
    }

    /**
     * 广度优先搜索
     */
}