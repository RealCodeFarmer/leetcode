package cn.meow.search.dfs.maxareaisland;

import javafx.util.Pair;

import java.util.Stack;

public class MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid == null) {
            return maxArea;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //计算岛屿大小
                    int size = islandSize(grid, i, j);
                    if (size > maxArea) {
                        maxArea = size;
                    }
                }
            }
        }
        return maxArea;
    }

    private int islandSize(int[][] grid, int i, int j) {
        //上下左右
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int result = 0;
        int m = grid.length;
        int n = grid[i].length;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(i, j));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pop = stack.pop();
            int cr = pop.getKey();
            int cc = pop.getValue();
            //是否访问过
            if (grid[cr][cc] != 1) {
                continue;
            }
            result++;
            grid[cr][cc] = 2;
            for (int[] d : direction) {
                int nr = cr + d[0];
                int nc = cc + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                stack.add(new Pair<>(nr, nc));
            }
        }
        return result;
    }
}
