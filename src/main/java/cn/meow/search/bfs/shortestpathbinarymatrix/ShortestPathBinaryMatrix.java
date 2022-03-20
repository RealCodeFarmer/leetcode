package cn.meow.search.bfs.shortestpathbinarymatrix;

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
                //因为我们要找的是最短路径，那么如果在此之前某个点已经在visited中，也就是说有其他路径在小于或等于当前步数的情况下，到达过这个点，证明到达这个点的最短路径已经被找到
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
