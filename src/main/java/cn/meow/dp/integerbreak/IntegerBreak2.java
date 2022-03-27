package cn.meow.dp.integerbreak;

public class IntegerBreak2 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        //0 不是正整数，1 是最小的正整数，0 和 1 都不能拆分
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                //将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)
                //将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
