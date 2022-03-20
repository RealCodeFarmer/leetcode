package cn.meow.tree.postordertraversal;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

    /**
     * 迭代
     * 队列
     * 前序遍历为 root -> left -> right
     * 后序遍历为 left -> right -> root
     * 可以修改前序遍历成为 root -> right -> left, 那么这个顺序就和后序遍历正好相反
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offerFirst(node.left);
            }
            if (node.right != null) {
                queue.offerFirst(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
