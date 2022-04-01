package cn.meow.dp.wigglesubsequence;

public class WiggleSubsequence2 {


    /**
     * 动态规划
     * up[i]
     * 1. up[i-1] nums[i]<=nums[i-1]
     * 2. max(up[i-1], down[i-1]+1) nums[i]>nums[i-1]
     * <p>
     * down[i]
     * 1. down[i-1] nums[i]>=nums[i-1]
     * 2. max(up[i-1]+1, down[i-1]) nums[i]<nums[i-1]
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    /**
     * 优化的动态规划
     * 每有一个「峰」到「谷」的下降趋势，down 值才会增加
     * 每有一个「谷」到「峰」的上升趋势，up 值才会增加
     * down 与 up 的差的绝对值值恒不大于 1, up<=down+1 且 down<=up+1, 省去不必要的比较大小的过程
     */
    public int wiggleMaxLength2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
