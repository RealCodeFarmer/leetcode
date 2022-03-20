package cn.meow.tree.mergetwobinarytrees;

import cn.meow.tree.been.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees2 {

    /**
     * 广度优先搜索
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        //第一课树
        Queue<TreeNode> queue1 = new LinkedList<>();
        //第二棵树
        Queue<TreeNode> queue2 = new LinkedList<>();

        //装配根结点
        queue.offer(merged);
        queue1.offer(root1);
        queue2.offer(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;

            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    //两课树的左边都不为空, 合并数值
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    //第一课左边不为空, 第二棵树左边为空
                    node.left = left1;
                } else if (left2 != null) {
                    //第一课左边为空, 第二棵树左边不为空
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }
}