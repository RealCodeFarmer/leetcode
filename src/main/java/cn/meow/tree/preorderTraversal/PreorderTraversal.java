package cn.meow.tree.preorderTraversal;

import cn.meow.tree.been.TreeNode;
import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class PreorderTraversal {

    /**
     * 迭代
     * 队列
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.right != null) {
                queue.offerFirst(node.right);
            }
            if (node.left != null) {
                queue.offerFirst(node.left);
            }
        }
        return res;
    }

    /**
     * 递归
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
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
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
