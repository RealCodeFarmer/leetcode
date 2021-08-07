package cn.meow.tree.twoSumIVBST;

import cn.meow.tree.been.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumIVBST2 {

    /**
     * HashSet
     */
    public class Solution {
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            return find(root, k, set);
        }

        public boolean find(TreeNode root, int k, Set<Integer> set) {
            if (root == null) {
                return false;
            }
            //核心
            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);
            return find(root.left, k, set) || find(root.right, k, set);
        }
    }

    /**
     * BFS 和 HashSet
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.poll();
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }
}
