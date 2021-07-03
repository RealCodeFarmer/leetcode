package cn.meow.tree.secondMinimumNode;

import cn.meow.tree.been.TreeNode;

public class SecondMinimumNodeBinaryTree2 {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        //如果左结点跟根结点相等
        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }
        //如果右结点跟根结点相等
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }
        //两边都存在"小"的, 拿min
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        if (leftVal != -1) {
            return leftVal;
        }
        return rightVal;
    }
}
