package cn.meow.list.removeNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList {

    /**
     * 快指针先前进n, 步进一样, 当快指针到达终点, 慢指针的位置就是要删除的指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        //记录前一个指针
        ListNode pre = slow;
        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return head;
            }
        }
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        //刚好要删的位置就是起点位置
        if (pre == slow) {
            return slow.next;
        } else {
            pre.next = pre.next.next;
            return head;
        }
    }

}
