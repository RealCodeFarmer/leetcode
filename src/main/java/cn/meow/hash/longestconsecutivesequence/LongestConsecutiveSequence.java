package cn.meow.hash.longestconsecutivesequence;

import java.util.*;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (Integer val : nums) {
            list.add(val);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int max = 1;
        int cur = 1;
        Iterator<Integer> iterator = list.iterator();
        int pre = iterator.next();
        while (iterator.hasNext()) {
            int temp = iterator.next();
            if (temp == pre) {
                continue;
            }
            if (temp - pre == 1) {
                cur++;
            } else {
                cur = 1;
            }
            if (cur > max) {
                max = cur;
            }
            pre = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}
