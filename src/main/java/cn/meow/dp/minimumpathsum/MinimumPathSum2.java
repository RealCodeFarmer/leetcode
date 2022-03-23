package cn.meow.dp.minimumpathsum;

public class MinimumPathSum2 {

    public int minPathSum(int[][] grid) {
        //m x n 网格 grid
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    //当左边和上边都是矩阵边界时 起点位置
                    continue;
                } else if (i == 0) {
                    //当只有左边是矩阵边界时,只能从上面来
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    //当只有上边是矩阵边界时,只能从左面来
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    //当左边和上边都不是矩阵边界时
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
