package cn.meow.plan.algorithm.threshold.rotatearr;

public class RotateArr {

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int index = 0;
        // nums.length - k
        // nums.length-(nums.length+k)%nums.length 处理k>nums.length的情况
        for (int i = nums.length - (nums.length + k) % nums.length; i < nums.length; i++) {
            result[index] = nums[i];
            index++;
        }
        int newIndex = 0;
        for (int i = index; i < nums.length; i++) {
            result[i] = nums[newIndex];
            newIndex++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
