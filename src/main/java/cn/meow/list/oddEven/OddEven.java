package cn.meow.list.oddEven;

import cn.meow.list.bean.ListNode;

public class OddEven {

    /**
     * 奇偶两个链表
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode result = l1;
        ListNode temp = l2;
        int i = 1;
        while (head != null) {
            ListNode next = head.next;
            if (i % 2 == 0) {
                l2.next = head;
                l2 = l2.next;
                l2.next = null;
            } else {
                l1.next = head;
                l1 = l1.next;
                l1.next = null;
            }
            head = next;
            i++;
        }
        l1.next = temp.next;
        return result.next;
    }
}
