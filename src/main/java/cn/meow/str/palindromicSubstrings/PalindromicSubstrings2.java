package cn.meow.str.palindromicSubstrings;

public class PalindromicSubstrings2 {

    private int cnt = 0;

    /**
     * 从字符串的某一位开始，尝试着去扩展子字符串
     */
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            //奇数长度
            extendSubstrings(s, i, i);
            //偶数长度
            extendSubstrings(s, i, i + 1);
        }
        return cnt;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            //左右两边扩散
            start--;
            end++;
            cnt++;
        }
    }
}
