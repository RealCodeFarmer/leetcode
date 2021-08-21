package cn.meow.stackQueue.dailyTemperatures;

public class DailyTemperatures {

    /**
     * 遍历
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 1;
            boolean isMax = false;
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] <= temperatures[i]) {
                    count++;
                } else {
                    isMax = true;
                    break;
                }
            }
            result[i] = isMax ? count : 0;
        }
        return result;
    }
}
