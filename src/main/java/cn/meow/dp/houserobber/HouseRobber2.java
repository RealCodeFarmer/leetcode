package cn.meow.dp.houserobber;

public class HouseRobber2 {

    /**
     * dp + 滚动数组
     * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量
     * 由于不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以
     * dp[i]=max(dp[i-2]+nums[i],dp[i-1])
     */
    public int rob(int[] nums) {
        int pre2 = 0;
        int pre1 = 0;
        for (int num : nums) {
            int cur = Math.max(pre2 + num, pre1);
            //不偷
            pre2 = pre1;
            //偷
            pre1 = cur;
        }
        return pre1;
    }

    /**
     * dp
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
