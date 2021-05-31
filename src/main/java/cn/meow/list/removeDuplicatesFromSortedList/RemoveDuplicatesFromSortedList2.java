package cn.meow.list.removeDuplicatesFromSortedList;

import cn.meow.list.bean.ListNode;

public class RemoveDuplicatesFromSortedList2 {

    /**
     * 迭代
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 递归
     */
    public ListNode deleteDuplicates2(ListNode head) {
        //若head为空链表，直接返回
        //若递归到只剩一个节点，返回该节点
        if (head == null || head.next == null) {
            return head;
        }
        //将去重后的以当前节点的后驱节点为头节点的链表连接在当前节点后边
        head.next = deleteDuplicates2(head.next);
        //若当前节点的值与其后驱节点是重复的，删除后驱节点
        if (head.val == head.next.val) {
            head.next = head.next.next;
        }
        //返回当前节点
        return head;
    }

    /**
     * 快慢指针
     */
    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
                slow.next = fast;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }
}
