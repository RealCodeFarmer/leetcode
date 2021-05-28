package cn.meow.list.reverse;

public class Reverse {

    public ListNode reverseList(ListNode head) {
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
