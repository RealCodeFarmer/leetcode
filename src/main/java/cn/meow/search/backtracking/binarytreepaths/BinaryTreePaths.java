package cn.meow.search.backtracking.binarytreepaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePaths {

    private static class TreeNode {
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
        if (root == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        backtracking(result, root, "");
        return result;
    }

    private void backtracking(List<String> result, TreeNode root, String str) {
        //终止条件
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(str + root.val);
            return;
        }
        //处理节点
        str += root.val + "->";
        //递归
        backtracking(result, root.left, str);
        backtracking(result, root.right, str);
        //回溯 使用不可变String 不需要考虑退一步
    }
}
