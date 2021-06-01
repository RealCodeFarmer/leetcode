package cn.meow.list.split;

import cn.meow.list.bean.ListNode;

public class Split {

    /**
     * 拆分链表
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] listNodes = new ListNode[k];
        int length = 0;
        ListNode cur = root;
        //求出链表长度
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        //商, 每一份多少个
        int quotient = length / k;
        //余数
        int residue = length % k;
        cur = root;
        //链表的长度 < 要分割数
        if (quotient == 0) {
            for (int i = 0; i < residue; i++) {
                if (cur == null) {
                    continue;
                }
                listNodes[i] = cur;
                cur = cur.next;
                listNodes[i].next = null;
            }
        } else {
            //题目要求: 任意两部分的长度差距不能超过 1
            for (int i = 0; i < k; i++) {
                listNodes[i] = cur;
                for (int j = 0; j < quotient - 1; j++) {
                    cur = cur.next;
                }
                //题目要求: 排在前面的部分的长度应该大于或等于后面的长度
                //把多出来的塞到前面的数组中
                if (residue != 0) {
                    cur = cur.next;
                    residue--;
                }
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
        }

        return listNodes;
    }

    public ListNode[] splitListToParts2(ListNode root, int k) {
        ListNode[] listNodes = new ListNode[k];
        int length = 0;
        ListNode cur = root;
        //求出链表长度
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        //商, 每一份多少个
        int quotient = length / k;
        //余数
        int residue = length % k;
        cur = root;
        //题目要求: 任意两部分的长度差距不能超过 1
        for (int i = 0; i < k; i++) {
            listNodes[i] = cur;
            for (int j = 0; j < quotient - 1; j++) {
                cur = cur.next;
            }
            //题目要求: 排在前面的部分的长度应该大于或等于后面的长度
            //把多出来的塞到前面的数组中
            if (quotient!=0 && residue != 0) {
                cur = cur.next;
                residue--;
            }
            if (cur != null) {
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
        }

        return listNodes;
    }
}
