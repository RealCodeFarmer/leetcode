package cn.meow.plan.algorithm.threshold.lettercasepermutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation2 {

    /**
     * 递归
     */
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c : s.toCharArray()) {
            int n = ans.size();
            //是否为字母
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    //添加一份复制
                    ans.add(new StringBuilder(ans.get(i)));
                    //当前位置后面拼接小写字母
                    ans.get(i).append(Character.toLowerCase(c));
                    //复制出来的那份后面拼接大写字母
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                //数字直接添加到每个字符串的末尾
                for (int i = 0; i < n; ++i) {
                    ans.get(i).append(c);
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (StringBuilder sb : ans)
            result.add(sb.toString());
        return result;
    }

    /**
     * 二分掩码
     */
    public List<String> letterCasePermutation2(String s) {
        int B = 0;
        for (char c : s.toCharArray()) {
            //是否为字母
            if (Character.isLetter(c)) {
                B++;
            }
        }
        //结果集
        List<String> ans = new ArrayList<>();
        for (int bits = 0; bits < (1 << B); bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char letter : s.toCharArray()) {
                if (Character.isLetter(letter)) {
                    if (((bits >> b++) & 1) == 1) {
                        word.append(Character.toLowerCase(letter));
                    } else {
                        word.append(Character.toUpperCase(letter));
                    }
                } else {
                    word.append(letter);
                }
            }
            ans.add(word.toString());
        }
        return ans;
    }
}
