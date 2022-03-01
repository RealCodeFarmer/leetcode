package cn.meow.search.dfs.surroundedRegions;

import javafx.util.Pair;

import java.util.Stack;

public class SurroundedRegions {
    //上下左右
    private int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     * 从外层的'O'填进去,剩下的O就是被包围的
     */
    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        //m x n 的矩阵
        int m = board.length;
        int n = board[0].length;
        //填充外围
        for (int i = 0; i < m; i++) {
            fillPeriphery(board, i, 0);
            fillPeriphery(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            fillPeriphery(board, 0, i);
            fillPeriphery(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 从外围开始填充
     */
    private void fillPeriphery(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(i, j));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pop = stack.pop();
            Integer key = pop.getKey();
            Integer value = pop.getValue();
            if (key < 0 || key >= m || value < 0 || value >= n || board[key][value] != 'O') {
                continue;
            }
            board[key][value] = 'T';
            for (int[] d : direction) {
                int nr = key + d[0];
                int nc = value + d[1];
                stack.add(new Pair<>(nr, nc));
            }
        }
    }
}
