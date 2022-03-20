package cn.meow.bit.singlenumber;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
