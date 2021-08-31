package cn.meow.str.countBinarySubstrings;

import java.util.HashSet;
import java.util.Set;

public class CountBinarySubstrings {

    /**
     * 超時
     */
    public int countBinarySubstrings(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 2; j <= length; j++) {
                if (isPalindromic(s.substring(i, j))) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isPalindromic(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        char temp = chars[0];
        int cnt = 0;
        boolean isChange = false;
        for (char c : chars) {
            if (c != temp) {
                if (isChange) {
                    return false;
                }
                temp = c;
                isChange = true;
            }
            if (isChange) {
                cnt--;
                continue;
            }
            cnt++;
        }
        return isChange && cnt == 0;
    }
}
