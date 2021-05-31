package cn.meow.list.palindrome;

import cn.meow.list.bean.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Palindrome {

    /**
     * 栈
     */
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null && !stack.empty()) {
            ListNode pop = stack.pop();
            if (pop.val != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 数组
     */
    public boolean isPalindrome2(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int stars = 0;
        int end = vals.size() - 1;
        while (end > stars) {
            if (!vals.get(stars).equals(vals.get(end))) {
                return false;
            }
            stars++;
            end--;
        }
        return true;
    }
}