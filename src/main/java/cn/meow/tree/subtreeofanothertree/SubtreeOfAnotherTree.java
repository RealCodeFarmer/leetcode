package cn.meow.tree.subtreeofanothertree;

import cn.meow.tree.been.TreeNode;

public class SubtreeOfAnotherTree {

    /**
     * 双重遍历
     * 借鉴了前一道题(PathSum III)
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        //转成小问题就是两棵树是否相等
        return isEquals(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEquals(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            //若有一方为空树
            return false;
        }
        if (root.val == subRoot.val) {
            return isEquals(root.left, subRoot.left) && isEquals(root.right, subRoot.right);
        }
        return false;
    }
}
