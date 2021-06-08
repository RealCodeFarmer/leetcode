package cn.meow.greedyThinking.assignCookies;

import java.util.Arrays;

public class AssignCookies {

    /**
     * 胃口值 g[i]
     * 饼干尺寸 s[j]
     */
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index < 0) {
                break;
            }
            if (g[i] <= s[index]) {
                index--;
                result++;
            }
        }
        return result;
    }
}
