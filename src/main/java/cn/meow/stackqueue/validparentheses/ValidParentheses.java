package cn.meow.stackqueue.validparentheses;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == ')') {
                if (stack.isEmpty() || !Character.valueOf('(').equals(stack.pop())) {
                    return false;
                }
            } else if (cur == ']') {
                if (stack.isEmpty() || !Character.valueOf('[').equals(stack.pop())) {
                    return false;
                }
            } else if (cur == '}') {
                if (stack.isEmpty() || !Character.valueOf('{').equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }
}
