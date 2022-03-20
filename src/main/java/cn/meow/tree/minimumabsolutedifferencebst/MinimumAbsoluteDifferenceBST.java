package cn.meow.tree.minimumabsolutedifferencebst;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceBST {
    private List<Integer> lists = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        //题意: 所有节点为非负值的二叉搜索树, 树中至少有 2 个节点
        int result = Integer.MAX_VALUE;
        mid(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = i + 1; j < lists.size(); j++) {
                int val = lists.get(i) - lists.get(j);
                val = val > 0 ? val : -val;
                if (val < result) {
                    result = val;
                }
            }
        }
        return result;
    }

    private void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        lists.add(root.val);
        mid(root.right);
    }
}
