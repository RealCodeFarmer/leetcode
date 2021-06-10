package cn.meow.greedyThinking.bestTimeToBuyII;

public class BestTimeToBuyII {

    /**
     * 暴力法
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        int i = 1;
        int min;
        int max;
        while (i < prices.length) {
            //两两比较,找出小的
            while (i < prices.length && prices[i] <= prices[i - 1]) {
                i++;
            }
            min = prices[i - 1];
            //从小的往后面找一个大的,也就是开始有收益的
            while (i < prices.length && prices[i] >= prices[i - 1]) {
                i++;
            }
            max = prices[i - 1];
            res += max - min;
        }
        return res;
    }

    /**
     * 贪心
     * 只要有利可图都卖了, 频繁买卖
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}