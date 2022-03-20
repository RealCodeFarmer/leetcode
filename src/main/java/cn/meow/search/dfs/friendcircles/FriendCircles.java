package cn.meow.search.dfs.friendcircles;

import javafx.util.Pair;

import java.util.Stack;

public class FriendCircles {

    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        if (isConnected == null) {
            return result;
        }
        //n x n 的矩阵
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    markConnected(isConnected, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void markConnected(int[][] isConnected, int i, int j) {
        int n = isConnected[i].length;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(i, j));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pop = stack.pop();
            Integer key = pop.getKey();
            Integer value = pop.getValue();
            if (isConnected[key][value]!=1) {
                continue;
            }
            isConnected[key][value] = 0;
            isConnected[value][key] = 0;
//            for (int k = 0; k < n; k++) {
//                if (isConnected[key][k]!=1) {
//                    continue;
//                }
//                stack.add(new Pair<>(key, k));
//            }
            for (int k = 0; k < n; k++) {
                if (isConnected[value][k]!=1.) {
                    continue;
                }
                stack.add(new Pair<>(value, k));
            }
        }
    }
}
