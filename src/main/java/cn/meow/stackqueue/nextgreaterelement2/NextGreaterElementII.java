package cn.meow.stackqueue.nextgreaterelement2;

public class NextGreaterElementII {

    /**
     * 遍历
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int val = -1;
            for (int j = (i + 1) % length; j != i; ) {
                if (nums[j] > nums[i]) {
                    val = nums[j];
                    break;
                }
                j = (j + 1) % length;
            }
            result[i] = val;
        }
        return result;
    }
}
