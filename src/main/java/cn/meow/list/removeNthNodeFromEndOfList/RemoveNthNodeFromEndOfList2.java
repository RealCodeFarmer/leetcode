package cn.meow.list.removeNthNodeFromEndOfList;

import cn.meow.list.bean.ListNode;

public class RemoveNthNodeFromEndOfList2 {

    /**
     * 暴力解法
     * 遍历得到链表长度
     * Length - n + 1 即为要删除的结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //哑指针
        ListNode dummy = new ListNode(0, head);
        //链表长度
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }


    /**
     * 栈
     * [先进后出]原则
     * 弹出栈的第 nn 个结点就是需要删除的结点
     */


    /**
     * 快慢指针(哑结点)
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //哑指针
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        //题目提示: 1 <= n <= 链表结点的数目
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}