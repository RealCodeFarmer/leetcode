package cn.meow.list.swapnodesinpairs;

import cn.meow.list.bean.ListNode;

public class SwapNodesInPairs {

    /**
     * 递归
     * s -> f-> swapPairs(ListNode)
     * f-> swapPairs(ListNode) <- s
     * f -> s -> swapPairs(ListNode)
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        slow.next = fast.next;
        fast.next = slow;
        slow.next = swapPairs(slow.next);
        return fast;
    }
}
