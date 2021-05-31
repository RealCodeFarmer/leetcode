package cn.meow.list.mergeTwoSortedLists;

import cn.meow.list.bean.ListNode;

public class MergeTwoSortedLists2 {

    /**
     * 递归
     * 公式↓                             条件↓
     * list1[0]+merge(list1[1:],list2) list1[0]<list2[0]
     * list2[0]+merge(list1,list2[1:]) otherwise
     * <p>
     * 较小的一头 与 已经合并完成的结果 连起来
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
