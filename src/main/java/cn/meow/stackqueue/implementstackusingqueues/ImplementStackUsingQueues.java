package cn.meow.stackqueue.implementstackusingqueues;

import java.util.LinkedList;

public class ImplementStackUsingQueues {

    LinkedList<Integer> q1;
    LinkedList<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (q1.isEmpty()){
            q2.offer(x);
        }else {
            q1.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int result = -1;
        if (q1.isEmpty()) {
            while (!q2.isEmpty()) {
                if (q2.size() == 1) {
                    result = q2.pop();
                } else {
                    q1.offer(q2.pop());
                }
            }
        } else if (q2.isEmpty()) {
            while (!q1.isEmpty()) {
                if (q1.size() == 1) {
                    result = q1.pop();
                } else {
                    q2.offer(q1.pop());
                }
            }
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int result = -1;
        if (q1.isEmpty()) {
            while (!q2.isEmpty()) {
                if (q2.size() == 1) {
                    result = q2.peek();
                }
                q1.offer(q2.pop());
            }
        } else if (q2.isEmpty()) {
            while (!q1.isEmpty()) {
                if (q1.size() == 1) {
                    result = q1.peek();
                }
                q2.offer(q1.pop());
            }
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
