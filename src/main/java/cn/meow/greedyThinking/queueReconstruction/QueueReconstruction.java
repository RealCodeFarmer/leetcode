package cn.meow.greedyThinking.queueReconstruction;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        //先身高降序 再人数升序
        //身高由高到低, 前面人数对的上的情况下直接尾插, 才不会影响后面的顺序
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //双向链表
        Node head = new Node(null, null, null);
        Node node = new Node(people[0], head, null);
        head.next = node;
        for (int i = 1; i < people.length; i++) {
            Node temp = head.next;
            int count = 0;
            while (temp != null) {
                if (people[i][1] == 0) {
                    //如果前面没有身高大于等于他的人
                    if (temp.val[0] > people[i][0]) {
                        //插入前面
                        Node pre = temp.pre;
                        Node newNode = new Node(people[i], pre, temp);
                        pre.next = newNode;
                        temp.pre = newNode;
                        break;
                    }
                    //到末尾了
                    if (temp.next == null) {
                        //插到最後
                        Node newNode = new Node(people[i], temp, null);
                        temp.next = newNode;
                        break;
                    }
                } else {
                    if (temp.val[0] >= people[i][0]) {
                        count++;
                    }
                    if (count == people[i][1]) {
                        //插后面
                        Node next = temp.next;
                        Node newNode = new Node(people[i], temp, next);
                        if (next != null) {
                            next.pre = newNode;
                        }
                        temp.next = newNode;
                        break;
                    }
                }
                temp = temp.next;
            }
        }

        //遍历链表
        for (int i = 0; i < people.length; i++) {
            people[i] = head.next.val;
            head = head.next;
        }
        return people;
    }

    class Node {
        int[] val;
        Node pre;
        Node next;

        public Node(int[] val) {
            this.val = val;
        }

        public Node(int[] val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
