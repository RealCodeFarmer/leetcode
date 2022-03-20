package cn.meow.stackqueue.implementqueueusingstacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        //栈2弹回栈1
        stackAll(s2, s1);
        //x入栈2
        s2.push(x);
        //栈1弹回栈2
        stackAll(s1, s2);
    }

    /**
     * 把s1的元素弹到s2
     */
    private void stackAll(Stack s1, Stack s2) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (s2.isEmpty()) {
            return -1;
        }
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (s2.isEmpty()) {
            return -1;
        }
        return s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s2.isEmpty();
    }
}
