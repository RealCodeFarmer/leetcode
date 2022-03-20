package cn.meow.tree.preordertraversal;

import cn.meow.tree.been.TreeNode;

import java.util.*;

public class PreorderTraversal2 {

    /**
     * 迭代
     * 栈
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            // 先右后左，保证左子树先遍历
            stack.push(node.right);
            stack.push(node.left);
        }
        return ret;
    }

    /**
     * Morris 遍历
     * 如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点。然后将当前节点加入答案，并将当前节点更新为当前节点的左子节点。
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            TreeNode p1 = root;
            TreeNode p2 = null;

            while (p1 != null) {
                p2 = p1.left;
                if (p2 != null) {
                    while (p2.right != null && p2.right != p1) {
                        p2 = p2.right;
                    }
                    if (p2.right == null) {
                        res.add(p1.val);
                        p2.right = p1;
                        p1 = p1.left;
                        continue;
                    } else {
                        p2.right = null;
                    }
                } else {
                    res.add(p1.val);
                }
                p1 = p1.right;
            }
            return res;
        }
    }
}
