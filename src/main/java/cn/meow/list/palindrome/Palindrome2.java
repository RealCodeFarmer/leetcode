package cn.meow.list.palindrome;

import cn.meow.list.bean.ListNode;
import cn.meow.list.reverse.Reverse;

public class Palindrome2 {

    /**
     * 快慢指针
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        //找到前半部分链表的尾节点
        ListNode firstHalfEnd = endOfFirstHalf(head);
        //反转后半部分链表
        ListNode secondHalfStart = Reverse.reverseList(firstHalfEnd.next);

        //判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表
        //firstHalfEnd.next = Reverse.reverseList(secondHalfStart);
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
