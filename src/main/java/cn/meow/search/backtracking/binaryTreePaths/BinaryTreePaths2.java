package cn.meow.search.backtracking.binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    /**
     * 回溯
     *
     * @param node   二叉树
     * @param values 路径集
     * @param paths  结果集
     */
    private void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
        //终止条件
        if (node == null) {
            return;
        }
        values.add(node.val);
        //是否叶子节点
        if (isLeaf(node)) {
            paths.add(buildPath(values));
        } else {
            //递归
            backtracking(node.left, values, paths);
            backtracking(node.right, values, paths);
        }
        //回溯
        values.remove(values.size() - 1);
    }

    /**
     * 是否叶子节点
     */
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * 根据列表创建路径
     */
    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            //不是最后一个,后面就拼上 '箭头'
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }
}
