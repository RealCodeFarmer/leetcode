package cn.meow.tree.kthSmallestElementBST;

import cn.meow.tree.been.TreeNode;

import java.lang.annotation.Target;
import java.util.*;

public class KthSmallestElementBST {

    /**
     *  迭代
     *  中序遍历修改, 思路最左边的是最小的
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret.get(k - 1);
    }
}
