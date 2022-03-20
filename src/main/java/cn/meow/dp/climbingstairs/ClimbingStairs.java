package cn.meow.dp.climbingstairs;

public class ClimbingStairs {

    /**
     * 超时
     */
    public int climbStairs(int n) {
        int[] visit = new int[n + 1];
        return climbStairs(n, visit);
    }

    private int climbStairs(int n, int[] visit) {
        if (visit[n] > 0) {
            return visit[n];
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1, visit) + climbStairs(n - 2, visit);
    }
}
