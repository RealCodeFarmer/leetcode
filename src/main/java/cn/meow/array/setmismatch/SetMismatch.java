package cn.meow.array.setmismatch;

public class SetMismatch {

    /**
     * 题意: 集合 s 包含从 1 到 n 的整数
     */
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        //排序
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
        //找出重复的数字
        int pre = nums[0];
        int cur = nums[0];
        for (int i = 1; i < length; i++) {
            cur = nums[i];
            if (nums[i] == pre) {
                break;
            }
            pre = cur;
        }
        int x = 1;
        for (int i = 0; i < length; i++) {
            if (x != nums[i]) {
                if (x > nums[i]) {
                    continue;
                }
                return new int[]{cur, x};
            }
            x++;
        }
        return x == nums.length ? new int[]{cur, length} : nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
