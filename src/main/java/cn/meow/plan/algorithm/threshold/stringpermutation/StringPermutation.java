package cn.meow.plan.algorithm.threshold.stringpermutation;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    private List<String> list = new ArrayList<>();

    /**
     * 超出内存限制
     */
    public boolean checkInclusion(String s1, String s2) {
        backtracking(s1, s1.length(), new StringBuilder(), new boolean[s1.length()]);
        for (String s : list) {
            if (s2.contains(s)) {
                return true;
            }
        }
        return false;
    }

    private void backtracking(String s1, int n, StringBuilder sb, boolean[] isVisit) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isVisit[i]) {
                continue;
            }
            isVisit[i] = true;
            char c = s1.charAt(i);
            sb.append(c);
            backtracking(s1, n, sb, isVisit);
            isVisit[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
