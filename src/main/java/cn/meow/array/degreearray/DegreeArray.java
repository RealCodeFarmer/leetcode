package cn.meow.array.degreearray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeArray {

    /**
     * 题意理解:
     * 1.找出出现次数最多的元素x
     * 2.求出包含所有x的子串
     * 3.最小的子串即是答案
     */
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //记录元素出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //元素出现频次最大值
        int maxCnt = 0;
        for (Integer value : map.values()) {
            maxCnt = Math.max(value, maxCnt);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxCnt)) {
                list.add(entry.getKey());
            }
        }
        //最小子串长度
        int result = nums.length;
        if (list != null && !list.isEmpty()) {
            for (Integer key : list) {
                //计算子串长度
                int count = 0;
                int cnt = maxCnt;
                boolean first = false;
                for (int num : nums) {
                    if (num == key) {
                        cnt--;
                        first = true;
                    }
                    if (first) {
                        count++;
                    }
                    if (cnt == 0) {
                        break;
                    }
                }
                result = Math.min(result, count);
            }
        }
        return result;
    }
}
