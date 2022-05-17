package cn.meow.dp.stocktrading.cooldown;

public class Cooldown2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n];
        int[] s1 = new int[n];
        int[] sell = new int[n];
        int[] s2 = new int[n];
        s1[0] = buy[0] = -prices[0];
        sell[0] = s2[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = s2[i - 1] - prices[i];
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
            s2[i] = Math.max(s2[i - 1], sell[i - 1]);
        }
        return Math.max(sell[n - 1], s2[n - 1]);
    }
}
