package cn.meow.stackQueue.dailyTemperatures;

import java.util.Stack;

public class DailyTemperatures2 {

    /**
     * 栈
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < length; curIndex++) {
            //当前位置的值比栈顶的大
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                //比它大的值之间的索引差
                result[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return result;
    }
}
