package cn.meow.stackQueue.nextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII2 {

    /**
     * 栈
     * 跟 <b>739.每日温度</b> 类似
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        //默认值设置为-1
        Arrays.fill(result, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < length * 2; i++) {
            int num = nums[i % length];
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                result[pre.pop()] = num;
            }
            if (i < length) {
                pre.push(i);
            }
        }
        return result;
    }
}
