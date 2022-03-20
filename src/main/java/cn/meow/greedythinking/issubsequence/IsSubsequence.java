package cn.meow.greedythinking.issubsequence;

public class IsSubsequence {

    /**
     * 双指针
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int sIndex = 0;
        int tIndex = 0;
        for (; sIndex < s.length() && tIndex < t.length(); tIndex++) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
        }
        return sIndex == s.length();
    }
}
