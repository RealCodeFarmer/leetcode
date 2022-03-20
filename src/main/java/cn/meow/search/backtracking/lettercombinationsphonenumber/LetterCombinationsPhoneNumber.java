package cn.meow.search.backtracking.lettercombinationsphonenumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        //获取对应位置(prefix.length())的'数字'
        int curDigits = digits.charAt(prefix.length()) - '0';
        //通过对应'数字'获取key
        String letters = KEYS[curDigits];
        for (char c : letters.toCharArray()) {
            //添加
            prefix.append(c);
            doCombination(prefix, combinations, digits);
            //删除
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
