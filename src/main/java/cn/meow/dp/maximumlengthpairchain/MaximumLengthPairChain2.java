package cn.meow.dp.maximumlengthpairchain;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthPairChain2 {

    /**
     * 动态规划
     */
    public int findLongestChain(int[][] pairs) {
        //根据数对第一个元素进行升序排序
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                //跟之前的元素的尾巴进行比较
                if (pairs[i][1] < pairs[j][0])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }
        //拿到最大的dp返回
        int ans = 0;
        for (int x : dp) {
            if (x > ans) {
                ans = x;
            }
        }
        return ans;
    }

    /**
     * 贪心
     */
    public int findLongestChain2(int[][] pairs) {
        //根据数对第二个元素进行升序排序
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int cur = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }
        return ans;
    }
}
