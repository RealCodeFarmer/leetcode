package cn.meow.str.longestPalindrome;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        //两个相同的字符可以构成回文
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.remove(c);
                result += 2;
            } else {
                map.put(c, 1);
            }
        }
        //当个字符放在最中间,可以构成回文
        return map.isEmpty() ? result : result + 1;
    }
}
