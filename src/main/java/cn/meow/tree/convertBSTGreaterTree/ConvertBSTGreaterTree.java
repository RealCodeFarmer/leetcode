package cn.meow.tree.convertBSTGreaterTree;

import cn.meow.tree.been.TreeNode;

import java.util.Stack;

public class ConvertBSTGreaterTree {

    /**
     * 迭代
     * 中序(左跟右)
     * 根据题意, 显然右根左
     * 先中序改动下, 记录上一次pre, 下一次累加
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int pre = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pop();
            pre += node.val;
            node.val = pre;
            cur = node.left;
        }
        return root;
    }
}
