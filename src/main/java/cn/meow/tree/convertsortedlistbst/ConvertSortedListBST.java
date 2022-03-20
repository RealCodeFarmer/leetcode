package cn.meow.tree.convertsortedlistbst;

import cn.meow.list.bean.ListNode;
import cn.meow.tree.been.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListBST {

    /**
     * 将链表转化为数组
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        List<Integer> lists = new ArrayList<>();
        while (head != null) {
            lists.add(head.val);
            head = head.next;
        }
        return covert(lists, 0, lists.size() - 1);
    }

    private TreeNode covert(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = covert(nums, start, mid - 1);
        node.right = covert(nums, mid + 1, end);
        return node;
    }
}
