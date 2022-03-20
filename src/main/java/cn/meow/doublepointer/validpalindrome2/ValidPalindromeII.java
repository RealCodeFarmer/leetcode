package cn.meow.doublepointer.validpalindrome2;

public class ValidPalindromeII {

    /**
     * 双指针
     * 如果不相等,要么就是head前进1,要么就是tail后退1
     */
    public boolean validPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (tail > head) {
            if (s.charAt(head) != s.charAt(tail)) {
                return isPalindrome(s, head + 1, tail) || isPalindrome(s, head, tail - 1);
            }
            head++;
            tail--;
        }
        return true;
    }

    /**
     * 双指针
     * 判断是否回文字符串
     */
    private boolean isPalindrome(String s, int head, int tail) {
        while (tail > head) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
