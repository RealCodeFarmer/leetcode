package cn.meow.array.degreearray;

import java.util.HashMap;
import java.util.Map;

public class DegreeArray2 {

    public int findShortestSubArray(int[] nums) {
        //出现的次数
        Map<Integer, Integer> numsCnt = new HashMap<>();
        //最后一次出现索引
        Map<Integer, Integer> numsLastIndex = new HashMap<>();
        //第一次出现的索引
        Map<Integer, Integer> numsFirstIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            numsLastIndex.put(num, i);
            if (!numsFirstIndex.containsKey(num)) {
                numsFirstIndex.put(num, i);
            }
        }
        //元素出现频次最大值
        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numsCnt.get(num));
        }
        //最小子串长度
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = numsCnt.get(num);
            if (cnt != maxCnt) {
                continue;
            }
            ret = Math.min(ret, numsLastIndex.get(num) - numsFirstIndex.get(num) + 1);
        }
        return ret;
    }
}
