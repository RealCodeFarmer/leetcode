package cn.meow.hash.longestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int maxNum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int curVal = 0;
            int curMax = 0;
            if (map.containsKey(num)) {
                Integer cur = map.get(num);
                map.put(num, cur + 1);
                curVal = cur + 1;
            } else {
                map.put(num, 1);
                curVal = 1;
            }
            //从左右两边找到最大边
            if (map.containsKey(num + 1)) {
                curMax = Math.max(curMax, map.get(num + 1));
            }
            if (map.containsKey(num - 1)) {
                curMax = Math.max(curMax, map.get(num - 1));
            }
            //元素全部相同的情况, 结果为0
            curMax = curMax != 0 ? curMax + curVal : 0;
            maxNum = Math.max(curMax, maxNum);
        }
        return maxNum;
    }
}
