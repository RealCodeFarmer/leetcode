package cn.meow.array.arrayNesting;

public class ArrayNesting {

    /**
     * 暴力
     */
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int index = i;
            int curIndex = i;
            int cnt = 1;
            while (curIndex < length) {
                curIndex = nums[curIndex];
                if (curIndex == index) {
                    break;
                }
                cnt++;
            }
            result = Math.max(cnt, result);
        }
        return result;
    }
}
