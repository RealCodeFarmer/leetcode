package cn.meow.str.palindromeNumber;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return isPalindromic(x + "");
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
