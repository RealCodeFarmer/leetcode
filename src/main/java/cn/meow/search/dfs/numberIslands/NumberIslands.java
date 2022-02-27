package cn.meow.search.dfs.numberIslands;

import javafx.util.Pair;

import java.util.Stack;

public class NumberIslands {

    public int numIslands(char[][] grid) {
        int maxArea = 0;
        if (grid == null) {
            return maxArea;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    //计算岛屿大小
                    markIsland(grid, i, j);
                    maxArea++;
                }
            }
        }
        return maxArea;
    }

    /**
     * 把当前[i][j]岛屿区域标记
     */
    private void markIsland(char[][] grid, int i, int j) {
        //上下左右
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int m = grid.length;
        int n = grid[i].length;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(i, j));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pop = stack.pop();
            int cr = pop.getKey();
            int cc = pop.getValue();
            //是否访问过
            if (grid[cr][cc] != '1') {
                continue;
            }
            grid[cr][cc] = '2';
            for (int[] d : direction) {
                int nr = cr + d[0];
                int nc = cc + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                stack.add(new Pair<>(nr, nc));
            }
        }
    }
}
