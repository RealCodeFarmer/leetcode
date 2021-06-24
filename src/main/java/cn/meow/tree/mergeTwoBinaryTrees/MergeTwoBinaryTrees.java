package cn.meow.tree.mergeTwoBinaryTrees;

import cn.meow.tree.been.TreeNode;

public class MergeTwoBinaryTrees {

    /**
     * 递归
     * 深度优先搜索
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        int temp = 0;
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        temp = root1.val + root2.val;
        root1.val = temp;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
