package cn.meow.list.oddeven;

import cn.meow.list.bean.ListNode;

public class OddEven2 {

    /**
     * 分离节点后合并
     * 奇结点.next = 偶结点.next
     * 偶结点.next = 奇结点.next.next.next[即 (下一个奇结点).next]
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        //例如 1 2 3 4 o=1 e=2
        while (even != null && even.next != null) {
            //o=1 -> 3
            odd.next = even.next;
            //o=3
            odd = odd.next;
            //e=2 -> 4
            even.next = odd.next;
            //e=4
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
