package cn.meow.tree.houserobber3;

import cn.meow.tree.been.TreeNode;

public class HouseRobberIII2 {

    /**
     * 动态规划(后序遍历)
     */
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        //当前结点
        int[] res = new int[2];
        //当前结点不打劫的情况
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //当前结点打劫的情况
        res[1] = left[0] + right[0] + node.val;
        return res;
    }
}
