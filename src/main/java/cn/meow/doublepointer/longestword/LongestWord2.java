package cn.meow.doublepointer.longestword;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWord2 {

    /**
     * 先排序,遍历并检查子串
     */
    public String findLongestWord(String s, List<String> d) {
        //排序
        Collections.sort(d, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        for (String str : d) {
            if (isSubStr(s, str))
                return str;
        }
        return "";
    }

    /**
     * 符串可以通过删除 s 中的某些字符得到
     */
    private boolean isSubStr(String s, String strByDic) {
        if (strByDic.length() > s.length()) {
            return false;
        }
        int i = 0;
        for (int j = 0; i < strByDic.length() && j < s.length(); j++) {
            if (strByDic.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        return i == strByDic.length();
    }

    /**
     * 不排序
     */
    public String findLongestWord2(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length();
            int l2 = target.length();
            //如果将要检查的串比匹配上的串短 或者 长度一样字典序要大,不进行检查
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubStr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }
}
