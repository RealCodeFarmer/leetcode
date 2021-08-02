package cn.meow.tree.lowestCommonAncestor;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestorBinaryTree {

    /**
     * 遍历
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> findP = new ArrayList<>();
        List<TreeNode> findQ = new ArrayList<>();
        find(root, p.val, findP);
        find(root, q.val, findQ);

        TreeNode result = null;
        for (int i = findP.size() - 1, j = findQ.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (findP.get(i) == findQ.get(j)) {
                result = findP.get(i);
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 找父节点
     */
    private TreeNode find(TreeNode root, int val, List<TreeNode> list) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            list.add(root);
            return root;
        }
        TreeNode left = find(root.left, val, list);
        TreeNode right = find(root.right, val, list);
        if (left != null || right != null) {
            list.add(root);
            return root;
        }
        return null;
    }
}
