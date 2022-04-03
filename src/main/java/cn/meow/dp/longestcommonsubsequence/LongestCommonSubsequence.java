package cn.meow.dp.longestcommonsubsequence;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int iLength = text1.length();
        int jLength = text2.length();
        //留出0的位置,不用判断越界,方便统一处理
        int[][] dp = new int[iLength + 1][jLength + 1];
        for (int i = 1; i <= iLength; i++) {
            for (int j = 1; j <= jLength; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[iLength][jLength];
    }
}
