package cn.meow.dp._01knapsack.oneszeroes;

public class OnesZeroes2 {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            //注意:有一位偏移
            int[] count = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    //先把上一行抄下来
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = count[0];
                    int ones = count[1];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    public class Solution {

        /**
         * 因为当前行只参考了上一行的值，因此可以使用「滚动数组」，也可以「从后向前赋值」
         */
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 0;
            for (String s : strs) {
                int[] zeroAndOne = calcZeroAndOne(s);
                int zeros = zeroAndOne[0];
                int ones = zeroAndOne[1];
                for (int i = m; i >= zeros; i--) {
                    for (int j = n; j >= ones; j--) {
                        //能够使用 i 个 0 和 j 个 1 的字符串的最大数量
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    }
                }
            }
            return dp[m][n];
        }

        private int[] calcZeroAndOne(String str) {
            int[] res = new int[2];
            for (char c : str.toCharArray()) {
                res[c - '0']++;
            }
            return res;
        }
    }
}
