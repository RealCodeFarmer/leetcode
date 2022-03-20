package cn.meow.tree.convertbstgreatertree;

import cn.meow.tree.been.TreeNode;

public class ConvertBSTGreaterTree2 {

    private int sum = 0;

    /**
     * 递归
     */
    public TreeNode convertBST(TreeNode root) {
        depth(root);
        return root;
    }

    private void depth(TreeNode node) {
        if (node == null) {
            return;
        }
        depth(node.right);
        sum += node.val;
        node.val = sum;
        depth(node.left);
    }
}
