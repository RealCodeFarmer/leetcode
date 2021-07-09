package cn.meow.tree.postorderTraversal;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }
}
