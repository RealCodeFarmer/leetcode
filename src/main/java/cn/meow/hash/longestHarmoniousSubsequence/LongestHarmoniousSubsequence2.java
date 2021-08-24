package cn.meow.hash.longestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence2 {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                result = Math.max(result, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return result;
    }

}
