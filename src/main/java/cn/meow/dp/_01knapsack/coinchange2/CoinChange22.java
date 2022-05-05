package cn.meow.dp._01knapsack.coinchange2;

public class CoinChange22 {

    /**
     * 完全背包问题，使用 dp 记录可达成目标的组合数目
     */
    public int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
