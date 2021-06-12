package cn.meow.greedyThinking.maximumSubarray;

public class MaximumSubarray2 {

    /**
     * 贪心
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果当前和为负, 前面的部分不要
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    /**
     * 动态规划
     */
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //pre = Math.max(pre + x, x);
            //maxAns = Math.max(maxAns, pre);
            int temp = nums[i];
            if (nums[i - 1] > 0) {
                temp += nums[i - 1];
                nums[i] = temp;
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
