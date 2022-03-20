package cn.meow.str.countbinarysubstrings;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings2 {

    /**
     * 子串中0和1的个数相同，且所有相同的数字是相邻的
     */
    public int countBinarySubstrings(String s) {
        //前一种数字的个数
        int preLen = 0;
        //记录当前数字的个数
        int curLen = 1;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }

    class Solution {
        /**
         * 前面是连续 0/1 后面是连续 1/0 的数据
         * 取决于前面 0/1 的个数和后面 1/0 的个数 ,即min(cnt_pre, cnt_cur)
         */
        public int countBinarySubstrings(String s) {
            List<Integer> counts = new ArrayList<>();
            int ptr = 0;
            int n = s.length();
            while (ptr < n) {
                char c = s.charAt(ptr);
                int count = 0;
                while (ptr < n && s.charAt(ptr) == c) {
                    ++ptr;
                    ++count;
                }
                counts.add(count);
            }
            int result = 0;
            for (int i = 1; i < counts.size(); ++i) {
                result += Math.min(counts.get(i), counts.get(i - 1));
            }
            return result;
        }

        public int countBinarySubstrings2(String s) {
            int n = s.length();
            int ptr = 0;
            int last = 0;
            int result = 0;
            while (ptr < n) {
                char c = s.charAt(ptr);
                int count = 0;
                while (ptr < n && s.charAt(ptr) == c) {
                    ++ptr;
                    ++count;
                }
                result += Math.min(count, last);
                last = count;
            }
            return result;
        }
    }
}
