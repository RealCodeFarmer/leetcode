package cn.meow.list.IntersectionOfTwo;

public class IntersectionOfTwo2 {
    /**
     * 暴力
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            b = headB;
            while (b != null) {
                if (a == b) {
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }

    //方法二: 哈希表  装进HashSet, 使用contains找

    /**
     *  方法三: 双指针
     *  a + 相交 + b = b + 相交 + a
     *  起点虽然不一样, 但路程一样, 终点一样, 速度一样, 必定同时到达
     *
     *  没有交点的情况下都等于null, 相等退出
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
