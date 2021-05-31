package cn.meow.list.reverse;

import cn.meow.list.bean.ListNode;

public class Reverse {

    public static ListNode reverseList(ListNode head) {
        ListNode result = null;
        //遍历链表
        while (head != null) {
            //头插法
            ListNode temp = new ListNode();
            temp.next = result;
            temp.val = head.val;
            result = temp;
            head = head.next;
        }
        if (result == null) {
            return head;
        } else {
            return result;
        }
    }

}
