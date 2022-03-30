package cn.meow.dp.longestincreasingsubsequence;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                //比较当前元素前面的元素
                if (nums[i] > nums[j]) {
                    //当前元素比较大,被比较的元素最长递增子序列跟dp[i],取max
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //全局最长递增子序列
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
