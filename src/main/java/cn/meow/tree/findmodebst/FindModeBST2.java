package cn.meow.tree.findmodebst;

import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeBST2 {
    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] result = new int[maxCntNums.size()];
        int index = 0;
        for (int num : maxCntNums) {
            result[index++] = num;
        }
        return result;
    }

    /**
     * 中序遍历
     * 相同的元素会连在一起
     */
    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        inOrder(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) {
                curCnt++;
            } else {
                curCnt = 1;
            }
        }
        if (curCnt > maxCnt) {
            //如果当前的元素比较多, 清空list里面的数据
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }
}
