package cn.meow.list.removeDuplicatesFromSortedList;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        //-100 <= Node.val <= 100
        int temp = 65535;
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == temp) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            temp = cur.val;
            cur = cur.next;
        }
        return head;
    }

}
