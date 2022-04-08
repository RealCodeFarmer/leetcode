package cn.meow.dp._01knapsack;

public class Basic {

    /**
     * @param vol     为背包总体积
     * @param num     为物品数量
     * @param weights 数组存储 N 个物品的重量
     * @param values  数组存储 N 个物品的价值
     */
    public int knapsack(int vol, int num, int[] weights, int[] values) {
        int[][] dp = new int[num + 1][vol + 1];
        for (int i = 1; i <= num; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = 1; j <= vol; j++) {
                if (j >= w) {
                    //第 i 件物品添加到背包中
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    //第 i 件物品没添加到背包
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[num][vol];
    }

    /**
     * 空间优化
     * 前 i 件物品的状态仅与前 i-1 件物品的状态有关
     */
    public int knapsack2(int vol, int num, int[] weights, int[] values) {
        int[] dp = new int[vol + 1];
        for (int i = 1; i <= num; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = vol; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[vol];
    }
}
