package cn.meow.tree.convertSortedArrayBST;

import cn.meow.tree.been.TreeNode;

public class ConvertSortedArrayBST {

    /**
     * 递归
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return covert(nums, 0, nums.length - 1);
    }

    private TreeNode covert(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = covert(nums, start, mid - 1);
        node.right = covert(nums, mid + 1, end);
        return node;
    }
}
