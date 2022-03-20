package cn.meow.stackqueue.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues2 {


    private Queue<Integer> queue;

    public ImplementStackUsingQueues2() {
        queue = new LinkedList<>();
    }

    /**
     * 每次插入都让队列前面元素依次排到后面
     */
    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
