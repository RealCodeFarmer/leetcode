package cn.meow.plan.algorithm.threshold.rightnodepointer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RightNodePointer {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //把现有的放进stack
            Stack<Node> stack = new Stack<>();
            Node pre = null;
            while (size-- > 0) {
                Node cur = queue.poll();
                stack.add(cur);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                pop.next = pre;
                pre = pop;
            }
        }
        return root;
    }
}
