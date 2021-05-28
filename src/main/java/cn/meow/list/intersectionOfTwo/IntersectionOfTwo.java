package cn.meow.list.intersectionOfTwo;

/**
 * 理解错了,leetcode的问题不是比数值, 比的是地址
 */
public class IntersectionOfTwo {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            b = headB;
            while (b != null) {
                ListNode temp = a;
                while (temp != null && b != null
                        && temp.val == b.val) {
                    temp = temp.next;
                    b = b.next;
                }
                if (b == null && temp == null) {
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }

        return null;
    }

    public static ListNode encapsulateData(String str) {
        String subStr = str.substring(1, str.length() - 1);
        ListNode head = null;
        ListNode iterableTemp = null;
        for (String s : subStr.split(",")) {
            if (s != null && s.trim().length() != 0) {
                Integer i = Integer.valueOf(s);
                ListNode temp = new ListNode(i);
                if (iterableTemp == null) {
                    iterableTemp = temp;
                    head = temp;
                }
                iterableTemp.next = temp;
                iterableTemp = temp;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        String strByA = "[4,1,8,4,5]";
        String strByB = "[5,6,1,8,4,5]";

        ListNode headA = encapsulateData(strByA);
        ListNode headB = encapsulateData(strByB);

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }
}