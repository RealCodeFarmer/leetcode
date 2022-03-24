package cn.meow.dp.uniquepaths;

import java.util.Arrays;

public class UniquePaths2 {

    /**
     * 每个格子的路径总数,由当前格子的 左边跟上边格子 决定
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        //边界只有单边
        //第一行设为1
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        //第一列设为1
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        //其他格子 左边+上边 格子路径数
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    /**
     * 统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
