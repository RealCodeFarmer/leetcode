package cn.meow.str.palindromicsubstrings;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
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
        int length = chars.length - 1;
        for (int i = 0; i <= length; i++, length--) {
            if (chars[i] != chars[length]) {
                return false;
            }
        }
        return true;
    }
}
