package cn.meow.tree.kthsmallestelementbst;

import cn.meow.tree.been.TreeNode;

public class KthSmallestElementBST2 {
    private int cnt = 0;
    private int val;

    /**
     * 中序遍历写法
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }

    /**
     * 递归写法
     */
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            //左子树结点数
            int leftCnt = count(root.left);
            //当前root
            if (leftCnt == k - 1) {
                return root.val;
            }
            //在左边
            if (leftCnt > k - 1) {
                return kthSmallest(root.left, k);
            }
            //在右边
            return kthSmallest(root.right, k - leftCnt - 1);
        }

        private int count(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return 1 + count(node.left) + count(node.right);
        }
    }
}
