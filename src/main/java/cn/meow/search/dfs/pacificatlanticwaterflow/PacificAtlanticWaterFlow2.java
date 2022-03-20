package cn.meow.search.dfs.pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow2 {
    private int m, n;
    private int[][] heights;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return result;
        }
        //m × n 的长方形岛屿
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        //可达太平洋
        boolean[][] canReachP = new boolean[m][n];
        //可达大西洋
        boolean[][] canReachA = new boolean[m][n];
        //先遍历外圈
        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || heights[r][c] > heights[nextR][nextC]) {
                continue;
            }
            //没有越界并且海拔大于等于此点
            dfs(nextR, nextC, canReach);
        }
    }
}
