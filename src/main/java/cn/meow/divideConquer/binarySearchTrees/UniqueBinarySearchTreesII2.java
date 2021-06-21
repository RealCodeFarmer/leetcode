package cn.meow.divideConquer.binarySearchTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII2 {
    /**
     * 回溯
     * <p>
     * Input: 3
     * Output:
     * [
     * [1,null,3,2],
     * [3,2,null,1],
     * [3,1,null,null,2],
     * [2,1,3],
     * [1,null,2,null,3]
     * ]
     * Explanation:
     * The above output corresponds to the 5 unique BST's shown below:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        //轮流做根节点
        for (int i = start; i <= end; i++) {
            //获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            //获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            //从左子树集合中选出一棵左子树,从右子树集合中选出一棵右子树,拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    /**
     * 动态规划
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode>[] dp = new ArrayList[n + 1];
            //如果left 或 right为0, 就会出现空指针异常
            dp[0] = new ArrayList();
            if (n == 0) {
                return dp[0];
            }
            //如果不加null, 那么后面当left或right为0时, 就不会执行for循环, 而一旦left不执行, right也会被跳过
            dp[0].add(null);
            for (int i = 1; i <= n; i++) {
                dp[i] = new ArrayList();
                for (int root = 1; root <= i; root++) {
                    //root为根节点, left是root左边的节点数
                    int left = root - 1;
                    //同理, right为root右边的节点数
                    int right = i - root;
                /*
                    假设n为5,root是3,那么左边有2个节点,所以去dp[2]里面找,右边也有两个节点4,5。所以还去dp[2]里面找
                    因为只有dp[2]里面都是2个节点的数。但是dp[2]中的数只有1和2,我们要的是4,5
                    我们不妨将1,2加上root,你会发现正好是4,5
                    所以得到结论,左子树的值直接找前面节点数一样的dp索引,右子树的值也找前面一样的dp索引,
                    但是你需要加上root才能保证val是你需要的,所以右子树要重新创建,不然会破坏前面的树
                */
                    //如果dp[left]里有两种可能,dp[right]里有三种可能,那么总共有6种可能
                    for (TreeNode leftTree : dp[left]) {
                        for (TreeNode rightTree : dp[right]) {
                            //这个是每一种可能的root节点
                            TreeNode newRoot = new TreeNode(root);
                            //左子树直接连接
                            newRoot.left = leftTree;
                            //右子树创建一个新的树
                            newRoot.right = clone(root, rightTree);
                            //将一种可能加入dp中
                            dp[i].add(newRoot);
                        }
                    }
                }
            }
            //这个不用多说,答案在第n个数上
            return dp[n];
        }

        /**
         * 重新创建一个新的子树
         */
        public TreeNode clone(int val, TreeNode root) {
            //如果为null,返回
            if (root == null) {
                return null;
            }
            //创建节点时, 不要忘了还要加上那个root
            TreeNode newTree = new TreeNode(val + root.val);
            //递归左和右, 和先序遍历很像
            newTree.left = clone(val, root.left);
            newTree.right = clone(val, root.right);
            //返回回去的这个节点正好跟在你需要的右子树上
            return newTree;
        }
    }
}
