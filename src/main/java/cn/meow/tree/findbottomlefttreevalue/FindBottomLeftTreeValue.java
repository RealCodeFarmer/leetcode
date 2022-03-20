package cn.meow.tree.findbottomlefttreevalue;

import cn.meow.tree.been.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    /**
     * 层次遍历
     * 广度
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int sum = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                if (i == 1) {
                    sum = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }
}
