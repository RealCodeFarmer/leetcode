package cn.meow.tree.minimumAbsoluteDifferenceBST;

import cn.meow.tree.been.TreeNode;

public class MinimumAbsoluteDifferenceBST2 {

    int pre;
    int ans;

    /**
     * 中序遍历
     * 对升序数组 a 求任意两个元素之差的绝对值的最小值，答案一定为相邻两个元素之差的最小值
     * 二叉搜索树中序遍历得到的值序列是递增有序的
     */
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
