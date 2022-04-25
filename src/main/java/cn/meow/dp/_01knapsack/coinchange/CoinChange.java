package cn.meow.dp._01knapsack.coinchange;

import java.util.Arrays;

public class CoinChange {

    /**
     * 贪心算法不能实现
     */
    public int coinChange(int[] coins, int amount) {
        int result = 0;
        Arrays.sort(coins);
        int length = coins.length;
        int temp = amount;
        for (int i = length - 1; i >= 0; i--) {
            while (coins[i] <= temp) {
                result++;
                temp -= coins[i];
            }
        }
        if (temp > 0) {
            return -1;
        }
        return result;
    }
}