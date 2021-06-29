package cn.meow.tree.minimumDepthBinaryTree;

import cn.meow.tree.been.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree2 {

    /**
     * 深度优先搜索
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //叶子结点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }

    /**
     * 广度
     */
    class Solution {
        class QueueNode {
            //结点
            TreeNode node;
            //深度
            int depth;

            public QueueNode(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<QueueNode> queue = new LinkedList<>();
            queue.offer(new QueueNode(root, 1));
            while (!queue.isEmpty()) {
                QueueNode nodeDepth = queue.poll();
                TreeNode node = nodeDepth.node;
                int depth = nodeDepth.depth;
                //"第一个"叶子结点
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(new QueueNode(node.left, depth + 1));
                }
                if (node.right != null) {
                    queue.offer(new QueueNode(node.right, depth + 1));
                }
            }
            return 0;
        }
    }
}
