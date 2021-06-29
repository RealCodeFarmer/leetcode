package cn.meow.tree.minimumDepthBinaryTree;

import cn.meow.tree.been.TreeNode;
import javafx.scene.transform.Rotate;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {

    private int min = 100000;

    /**
     * 递归
     * 深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepth(root, 0);
        return min;
    }

    private void minDepth(TreeNode root, int preNum) {
        if (root == null) {
            if (min > preNum) {
                min = preNum;
            }
        }
        preNum++;
        //叶子结点
        if (root.left == null && root.right == null) {
            if (min > preNum) {
                min = preNum;
            }
        }
        if (root.left != null) {
            minDepth(root.left, preNum);
        }
        if (root.right != null) {
            minDepth(root.right, preNum);
        }
    }
}
