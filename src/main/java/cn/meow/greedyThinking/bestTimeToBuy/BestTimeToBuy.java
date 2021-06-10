package cn.meow.greedyThinking.bestTimeToBuy;

/**
 * 121. 买卖股票的最佳时机
 */
public class BestTimeToBuy {

    /**
     * 超出内存限制
     */
    public int maxProfit(int[] prices) {
        int[][] ints = new int[prices.length][prices.length];
        //计算收益
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            for (int j = i; j < prices.length; j++) {
                ints[i][j] = prices[j] - val;
                if (ints[i][j] > 0 && ints[i][j] > result) {
                    result = ints[i][j];
                }
            }
        }
        return result;
    }

    /**
     * 超出时间限制
     */
    public int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            for (int j = i; j < prices.length; j++) {
                int diffVal = prices[j] - val;
                if (diffVal > 0 && diffVal > result) {
                    result = diffVal;
                }
            }
        }
        return result;
    }

    /**
     * 超出时间限制
     */
    public int maxProfit3(int[] prices) {
        //如果后面的收益都是0
        int length = prices.length;
        for (int i = length - 1; i <= 0; i--) {
            if (prices[i] != 0) {
                length = i;
                break;
            }
        }
        int result = 0;
        int pre = prices[0];
        for (int i = 0; i < length; i++) {
            int val = prices[i];
            //如果下一个比前一个小就跳过
            if (pre < val) {
                continue;
            } else {
                pre = val;
            }
            for (int j = i; j < length; j++) {
                if (prices[j] == 0) {
                    continue;
                }
                int diffVal = prices[j] - val;
                if (diffVal > 0 && diffVal > result) {
                    result = diffVal;
                }
            }
        }
        return result;
    }
}
