package cn.meow.array.movezeroes;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                //交换位置
                int index = i - cnt;
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
