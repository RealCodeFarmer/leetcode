package cn.meow.tree.convertsortedlistbst;

import cn.meow.list.bean.ListNode;
import cn.meow.tree.been.TreeNode;

public class ConvertSortedListBST2 {

    /**
     * 快慢指针
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;  // 断开链表
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    /**
     * 利用快慢指针找到中间结点
     */
    private ListNode preMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    /**
     * 中序遍历
     * BST 的中序遍历，打印的节点值正是这个有序链表的节点值顺序
     */
    class Solution {
        ListNode ptr;

        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            ptr = head;
            return buildTree(0, length(head) - 1);
        }

        private TreeNode buildTree(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left + 1) / 2;
            TreeNode root = new TreeNode();
            TreeNode leftTree = buildTree(left, mid - 1);
            root.val = ptr.val;
            ptr = ptr.next;
            root.left = leftTree;
            root.right = buildTree(mid + 1, right);
            return root;
        }

        private int length(ListNode node) {
            int len = 0;
            while (node != null) {
                len++;
                node = node.next;
            }
            return len;
        }
    }
}
