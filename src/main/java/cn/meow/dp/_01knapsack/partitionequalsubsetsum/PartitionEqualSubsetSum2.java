package cn.meow.dp._01knapsack.partitionequalsubsetsum;

public class PartitionEqualSubsetSum2 {

    /**
     * 数组的和一定得是偶数
     * 0-1 背包问题选取的物品的容积总量 不能超过 规定的总量
     * 本题选取的数字之和需要 恰好等于 规定的和的一半
     * 物品一个一个选，容量也一点一点增加去考虑
     * 把初始化的 dp[i][0] 设置成为 true =>
     * 当 j - nums[i] == 0 成立的时候，根据上面分析，就说明单独的 nums[i] 这个数就恰好能够在被分割为单独的一组，其余的数分割成为另外一组
     * 当前行总是参考了它上面一行 「头顶上」 那个位置和「左上角」某个位置的值
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        //数组和
        int sum = computeArraySum(nums);
        //能被二整除,说明能分成两份
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                //相当于剪枝
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
