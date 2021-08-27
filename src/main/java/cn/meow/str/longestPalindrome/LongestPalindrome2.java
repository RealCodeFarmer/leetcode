package cn.meow.str.longestPalindrome;

public class LongestPalindrome2 {

    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        int result = 0;
        for (int cnt : cnts) {
            result += (cnt / 2) * 2;
        }
        if (result < s.length()) {
            // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
            result++;
        }
        return result;
    }
}
