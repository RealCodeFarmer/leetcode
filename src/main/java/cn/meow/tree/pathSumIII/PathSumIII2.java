package cn.meow.tree.pathSumIII;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII2 {

    /**
     * 双重递归
     * 题意: 路径不需要从根节点开始，也不需要在叶子节点结束
     * 但是路径方向必须是向下的（只能从父节点到子节点）
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        //每一个都作为根节点走一遍
        return pathSumStartWithRoot(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int pathSumStartWithRoot(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val == targetSum) {
            //这里不能return, 后面有可能加减同个数或者0的情况
            result++;
        }
        result += pathSumStartWithRoot(root.left, targetSum - root.val) + pathSumStartWithRoot(root.right, targetSum - root.val);
        return result;
    }


}
