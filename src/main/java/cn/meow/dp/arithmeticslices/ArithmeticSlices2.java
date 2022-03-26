package cn.meow.dp.arithmeticslices;

public class ArithmeticSlices2 {

    public int numberOfArithmeticSlices(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int n = a.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (a[i] - a[i - 1] == a[i - 1] - a[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int cnt : dp) {
            total += cnt;
        }
        return total;
    }
}
