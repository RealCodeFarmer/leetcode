package cn.meow.tree.findModeBST;

import cn.meow.tree.been.TreeNode;

import java.util.*;

public class FindModeBST {

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        //遍历每个节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                Integer val = poll.val;
                int newVal = 1;
                if (map.containsKey(val)) {
                    newVal = map.get(val) + 1;
                    map.put(val, newVal);
                } else {
                    map.put(val, newVal);
                }
                if (newVal > max) {
                    max = newVal;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
