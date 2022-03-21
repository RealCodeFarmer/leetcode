package cn.meow.dp.houserobber;

public class HouseRobber {

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * HouseRobberIII 的技巧
     */
    public int rob(int[] nums) {
        //创建树
        TreeNode root = new TreeNode(nums[0]);
        TreeNode head = root;
        for (int i = 1; i < nums.length; i++) {
            TreeNode tmp = new TreeNode(nums[i]);
            head.right = tmp;
            head = tmp;
        }
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