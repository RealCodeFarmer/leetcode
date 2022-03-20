package cn.meow.tree.postordertraversal;

import cn.meow.tree.been.TreeNode;

import java.util.*;

public class PostorderTraversal2 {

    /**
     * 迭代
     * 前序遍历为 root -> left -> right
     * 后序遍历为 left -> right -> root
     * 可以修改前序遍历成为 root -> right -> left, 那么这个顺序就和后序遍历正好相反
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            res.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(res);

        return res;
    }
}
