package cn.meow.search.bfs.shortestPathBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    /**
     * 超出时间限制
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<String> queue = new LinkedList<>();
        if (grid == null) {
            return -1;
        }
        int length = grid.length;
        if (length == 0 || grid[0][0] != 0) {
            return -1;
        }
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        queue.add("0_0");
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            //选一个最好的位置
            for (int cnt = 0; cnt < size; cnt++) {
                String curr = queue.poll();
                if (curr == null || curr.length() == 0) {
                    continue;
                }
                String[] split = curr.split("_");
                if (split.length < 2) {
                    continue;
                }
                int i = Integer.parseInt(split[0]);
                int j = Integer.parseInt(split[1]);
                //判断是否到最后位置了
                if (i + 1 == length && j + 1 == length) {
                    return count;
                }
                //标记去过的位置为1
                grid[i][j] = 1;
                for (int[] d : direction) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr < 0 || nr >= length || nc < 0 || nc >= length) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        continue;
                    }
                    queue.add(nr + "_" + nc);
                }
            }
        }
        return -1;
    }
}
