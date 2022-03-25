package cn.meow.plan.algorithm.threshold.lettercasepermutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        s = s.toUpperCase();
        List<String> result = new ArrayList<>();
        recursive(s, new StringBuilder(), 0, result);
        return result;
    }

    private void recursive(String s, StringBuilder sb, int index, List<String> result) {
        if (index == s.length()) {
            result.add(sb.toString());
            return;
        }
        //是否大写英文字母
        char c = s.charAt(index);
        if (c >= 65 && c <= 90) {
            //大写
            recursive(s, sb.append(c), index + 1, result);
            //回溯
            sb.deleteCharAt(sb.length()-1);
            //小写
            recursive(s, sb.append((char) (c + 32)), index + 1, result);
        } else {
            //数字不变
            recursive(s, sb.append(c), index + 1, result);
        }
        //回溯
        sb.deleteCharAt(sb.length()-1);
    }
}
