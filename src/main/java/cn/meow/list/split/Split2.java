package cn.meow.list.split;

import cn.meow.list.bean.ListNode;

public class Split2 {

    /**
     * 创建新列表
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        int width = length / k;
        int rem = length % k;

        ListNode[] listNodes = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            //哑结点
            ListNode head = new ListNode(0);
            //创建新链表
            ListNode newListNode = head;
            //宽度(每一份多少个) + 是否有剩余的需要塞入
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                //尾插法
                newListNode.next = new ListNode(cur.val);
                newListNode = newListNode.next;
                if (cur != null) {
                    cur = cur.next;
                }
            }
            listNodes[i] = head.next;
        }
        return listNodes;
    }

    /**
     * 拆分链表
     */
    public ListNode[] splitListToParts2(ListNode root, int k) {
        ListNode cur = root;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        int width = length / k;
        int rem = length % k;

        ListNode[] listNodes = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                //可以不判空
                if (cur != null) {
                    cur = cur.next;
                }
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            listNodes[i] = head;
        }
        return listNodes;
    }
}
