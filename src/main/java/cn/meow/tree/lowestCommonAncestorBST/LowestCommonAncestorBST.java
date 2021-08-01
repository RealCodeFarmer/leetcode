package cn.meow.tree.lowestCommonAncestorBST;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestorBST {

    /**
     * 遍历
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> findP = find(root, p);
        List<TreeNode> findQ = find(root, q);
        TreeNode result = null;
        for (int i = 0; i < findP.size() && i < findQ.size(); i++) {
            if (findP.get(i) == findQ.get(i)) {
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
    private List<TreeNode> find(TreeNode root, TreeNode node) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != node) {
            result.add(cur);
            if (node.val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        result.add(node);
        return result;
    }
}
