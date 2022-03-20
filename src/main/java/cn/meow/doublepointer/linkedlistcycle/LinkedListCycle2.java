package cn.meow.doublepointer.linkedlistcycle;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

    /**
     * 哈希表法
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<ListNode>();
        while (head != null) {
            //如果添加失败,就存在环形
            if (!listNodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            //到链表末尾了,没有环形
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //快慢指针重合,存在环形
        return true;
    }
}
