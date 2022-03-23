package cn.meow.plan.algorithm.threshold.rottenorange;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        //m x n 网格
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int orangeNum = 0;
        // 将所有的 2 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    seen[i][j] = true;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                } else {
                    orangeNum++;
                }
            }
        }
        int cnt = -1;
        // 广度优先搜索
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            while (size-- > 0) {
                int[] cell = queue.poll();
                int i = cell[0];
                int j = cell[1];
                for (int[] direction : directions) {
                    int ni = i + direction[0];
                    int nj = j + direction[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                        orangeNum--;
                        grid[ni][nj] = 2;
                        queue.offer(new int[]{ni, nj});
                        seen[ni][nj] = true;
                    }
                }
            }
        }
        //如果没有全部腐烂的话,返回-1
        if (orangeNum > 0) {
            cnt = -1;
        }
        //没有好橘子了,但是没有进行过腐烂过程,说明一开始就没有好橘子
        if (orangeNum == 0 && cnt == -1) {
            cnt =  0;
        }
        return cnt;
    }
}
