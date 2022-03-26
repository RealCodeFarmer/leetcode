package cn.meow.dp.arithmeticslices;

public class ArithmeticSlices {

    /**
     * 找规律
     * consecutive  1,2,3
     * sum          1,3,6
     * sum += (consecutive + 1)
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        int result = 0;
        int consecutive = 0;
        for (int i = 2; i < length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                consecutive++;
            } else {
                consecutive = 0;
            }
            result += consecutive;
        }
        return result;
    }
}
