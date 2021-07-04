package cn.meow.tree.findBottomLeftTreeValue;

import cn.meow.tree.been.TreeNode;

import java.util.*;

public class FindBottomLeftTreeValue2 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }
}
