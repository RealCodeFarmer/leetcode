package cn.meow.dp.stocktrading.cooldown;

public class Cooldown {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        // f[i][1]:这里的「处于冷冻期」指的是在第 i 天结束之后的状态, 即当天卖出了股票
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        // max(f[n−1][0],f[n−1][1],f[n−1][2]) 最后一天不应该持有股票=>
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
