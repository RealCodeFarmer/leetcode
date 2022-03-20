package cn.meow.tree.symmetrictree;

import cn.meow.tree.been.TreeNode;

public class SymmetricTree {

    /**
     * 递归
     * 深度
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        //两个都为空, 到底
        if (left == null && right == null) {
            return true;
        }
        //其中一个为空, 即不相等
        if (left == null || right == null) {
            return false;
        }
        //结点不相等
        if (left.val != right.val) {
            return false;
        }
        //左边的左边跟右边的右边
        //左边的右边跟右边的左边
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
