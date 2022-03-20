package cn.meow.hash.longestconsecutivesequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence2 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        //键为数组中的值作, 值为次数1
        for (int num : nums) {
            countForNum.put(num, 1);
        }
        for (int num : nums) {
            forward(countForNum, num);
        }
        return maxCount(countForNum);
    }

    /**
     * 求出num在数组中"累加"的最大连续
     */
    private int forward(Map<Integer, Integer> countForNum, int num) {
        if (!countForNum.containsKey(num)) {
            return 0;
        }
        int cnt = countForNum.get(num);
        if (cnt > 1) {
            return cnt;
        }
        cnt = forward(countForNum, num + 1) + 1;
        countForNum.put(num, cnt);
        return cnt;
    }

    /**
     * 找出数组中的最大值
     */
    private int maxCount(Map<Integer, Integer> countForNum) {
        int max = 0;
        for (int num : countForNum.keySet()) {
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }

    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int result = 0;

            for (int num : set) {
                //是否包含当前元素的前一个元素, 不包含的话, 即"第一个"元素
                if (!set.contains(num - 1)) {
                    int cur = num;
                    int curMax = 1;

                    while (set.contains(cur + 1)) {
                        cur += 1;
                        curMax += 1;
                    }

                    result = Math.max(result, curMax);
                }
            }

            return result;
        }
    }
}
