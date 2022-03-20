package cn.meow.doublepointer.longestword;

import java.util.List;

public class LongestWord {

    /**
     * 遍历并检查子串
     * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串
     */
    public String findLongestWord(String s, List<String> dictionary) {
        if (dictionary == null || dictionary.size() == 0
                || s == null || s.length() == 0) {
            return "";
        }
        String str = null;
        for (String strByDic : dictionary) {
            //如果是子串
            if (isSubStr(s, strByDic)) {
                if (str == null ||
                        strByDic.length() > str.length() ||
                        (strByDic.length() == str.length() && str.compareTo(strByDic) > 0)) {
                    str = strByDic;
                }
            }
        }
        return str == null ? "" : str;
    }

    /**
     * 符串可以通过删除 s 中的某些字符得到
     */
    private boolean isSubStr(String s, String strByDic) {
        if (strByDic.length() > s.length()) {
            return false;
        }
        char[] charsByS = s.toCharArray();
        char[] charsByStr = strByDic.toCharArray();
        int i = 0;
        for (int j = 0; i < charsByStr.length && j < charsByS.length; j++) {
            if (charsByStr[i] == charsByS[j]) {
                i++;
            }
        }
        if (i == charsByStr.length) {
            return true;
        }
        return false;
    }
}
