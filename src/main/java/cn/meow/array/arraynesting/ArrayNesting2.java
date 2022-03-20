package cn.meow.array.arraynesting;

public class ArrayNesting2 {

    /**
     * 索引指向唯一，所以可以把访问过的位置标记-1
     */
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                //标记该位置已经被访问
                nums[j] = -1;
                j = t;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
