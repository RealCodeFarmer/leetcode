package cn.meow.bit.missingNumber;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 1+2+...+n  ==>  (1+n)*n/2
        int length = nums.length;
        int total = length * (length + 1) / 2;
        for (int num : nums) {
            total -= num;
        }
        return total;
    }
}
