package cn.meow.search.bfs.shortestPathBinaryMatrix;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix2 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        // 可去的八个位置
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        // 题意: n x n 的二进制矩阵
        int n = grid.length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                // i
                int cr = cur.getKey();
                // j
                int cc = cur.getValue();
                // 如果是1, 即不能通过, 跳过此处循环
                if (grid[cr][cc] == 1) {
                    continue;
                }
                // 终点
                if (cr == n - 1 && cc == n - 1) {
                    return pathLength;
                }
                // 标记走过的地方为1
                grid[cr][cc] = 1;
                for (int[] d : direction) {
                    int nr = cr + d[0];
                    int nc = cc + d[1];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}
