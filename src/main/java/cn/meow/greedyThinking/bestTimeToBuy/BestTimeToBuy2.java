package cn.meow.greedyThinking.bestTimeToBuy;

public class BestTimeToBuy2 {

    /**
     * 一次遍历
     * <p>
     * 假设我们在第i天卖出股票, 那我们肯定希望买在[0 -> i-1]天中的最低点(即历史最低价)
     */
    public int maxProfit(int prices[]) {
        //记录历史最低价
        int minPrice = Integer.MAX_VALUE;
        //总遍历的最高收益
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
