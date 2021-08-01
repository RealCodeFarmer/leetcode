package cn.meow.tree.lowestCommonAncestorBST;

import cn.meow.tree.been.TreeNode;

public class LowestCommonAncestorBST2 {

    /**
     * 一次遍历
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        while (true) {
            if (p.val < result.val && q.val < result.val) {
                result = result.left;
            } else if (p.val > result.val && q.val > result.val) {
                result = result.right;
            } else {
                break;
            }
        }
        return result;
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
}
