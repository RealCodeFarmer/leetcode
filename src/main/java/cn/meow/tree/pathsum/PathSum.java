package cn.meow.tree.pathsum;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    private List<Integer> list = new ArrayList<>();

    /**
     * 递归
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean result = false;
        if (root == null) {
            return result;
        }
        depth(root, 0);
        if (list != null && !list.isEmpty()) {
            for (Integer integer : list) {
                if (integer.intValue() == targetSum) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private void depth(TreeNode root, int preVal) {
        root.val += preVal;
        if (root.left != null) {
            depth(root.left, root.val);
        }
        if (root.right != null) {
            depth(root.right, root.val);
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
    }

    class Solution {
        private boolean result = false;
        private int targetSum;

        public boolean hasPathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            if (root == null) {
                return result;
            }
            depth(root, 0);
            return result;
        }

        private void depth(TreeNode root, int preVal) {
            if (result) {
                return;
            }
            root.val += preVal;
            if (root.left != null) {
                depth(root.left, root.val);
            }
            if (root.right != null) {
                depth(root.right, root.val);
            }
            if (!result && root.left == null && root.right == null) {
                if (targetSum == root.val) {
                    result = true;
                    return;
                }
            }
        }
    }
}
