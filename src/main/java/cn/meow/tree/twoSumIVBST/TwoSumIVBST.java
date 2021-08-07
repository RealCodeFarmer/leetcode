package cn.meow.tree.twoSumIVBST;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVBST {

    private List<Integer> lists = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        mid(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = i + 1; j < lists.size(); j++) {
                if (lists.get(i) + lists.get(j) == k) {
                    return true;
                }
            }
        }
        return false;
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
