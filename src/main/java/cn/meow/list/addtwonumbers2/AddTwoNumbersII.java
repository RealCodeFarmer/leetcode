package cn.meow.list.addtwonumbers2;

import cn.meow.list.bean.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {

    /**
     * 栈
     * <p>
     * sum += (s1.pop * 1 + s1.pop * 10 + s1.pop * 100 + ...)
     * sum += (s2.pop * 1 + s2.pop * 10 + s2.pop * 100 + ...)
     * sum求余头插法
     * <p>
     * <b>位数太多会有问题</b>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        int i = 1;
        int sum = 0;
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                sum += s1.pop().val * i;
            }
            if (!s2.empty()) {
                sum += s2.pop().val * i;
            }
            i *= 10;
        }

        //[0] + [0] = [0]
        if (sum == 0) {
            return new ListNode(0, null);
        }
        ListNode result = new ListNode();
        while (sum > 0) {
            int residue = sum % 10;
            sum /= 10;
            //头插法
            ListNode residueNode = new ListNode();
            residueNode.val = residue;
            residueNode.next = result.next;
            result.next = residueNode;

        }
        return result.next;
    }

    /**
     * 栈
     * s1.pop() + s2.pop() + (上一次运算的进位数)
     * /10 得到进位数, 记录进位数
     * 头插法
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        ListNode result = new ListNode();
        //进位数
        int carryBit = 0;
        //需要判断carryBit != 0, 例: [5] + [5]
        while (!s1.empty() || !s2.empty() || carryBit != 0) {
            int v1 = 0;
            int v2 = 0;
            if (!s1.empty()) {
                v1 = s1.pop().val;
            }
            if (!s2.empty()) {
                v2 = s2.pop().val;
            }
            int temp = v1 + v2 + carryBit;
            //头插法
            ListNode residueNode = new ListNode();
            residueNode.val = temp % 10;
            residueNode.next = result.next;
            result.next = residueNode;
            carryBit = temp / 10;
        }
        return result.next;
    }
}
