package cn.meow.list.swapNodesInPairs;

import cn.meow.list.bean.ListNode;

public class SwapNodesInPairs2 {

    /**
     * 迭代
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //哑结点
        ListNode dummy = new ListNode(0, head);
        //要两两交换的结点 的前一个结点
        //dummy -> 1(temp.next) -> 2(temp.next.next)
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummy.next;
    }
}
