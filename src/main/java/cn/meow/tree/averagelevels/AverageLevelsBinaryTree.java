package cn.meow.tree.averagelevels;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 一棵树每层节点的平均数
 */
public class AverageLevelsBinaryTree {

    /**
     * 层次遍历
     * 广度
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Double> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}
