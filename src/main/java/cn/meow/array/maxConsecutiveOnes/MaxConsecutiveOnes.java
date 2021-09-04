package cn.meow.array.maxConsecutiveOnes;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int temp = 0;
        for (int num : nums) {
            if (num == 1) {
                temp++;
            } else {
                result = Math.max(result, temp);
                temp = 0;
            }
        }
        return Math.max(result, temp);
    }
}