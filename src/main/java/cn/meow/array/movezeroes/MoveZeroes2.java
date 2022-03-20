package cn.meow.array.movezeroes;

public class MoveZeroes2 {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            //遍历数组, 值不为0, 从左到右排放(当新数组使用)
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
