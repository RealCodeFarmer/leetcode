package cn.meow.stackqueue.minstack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> s1;
    //存放范围内的最小值
    private Stack<Integer> s2;
    private Integer min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        s1.push(val);
        min = Math.min(min, val);
        s2.push(min);
    }

    public void pop() {
        s1.pop();
        s2.pop();
        min = s2.isEmpty() ? Integer.MAX_VALUE : s2.peek();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
