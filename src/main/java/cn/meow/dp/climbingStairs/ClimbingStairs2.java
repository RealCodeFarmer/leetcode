package cn.meow.dp.climbingStairs;

public class ClimbingStairs2 {

    /**
     * dp[i] 只与 dp[i - 1] 和 dp[i - 2] 有关, 因此可以只用两个变量来存储 dp[i - 1] 和 dp[i - 2]
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
