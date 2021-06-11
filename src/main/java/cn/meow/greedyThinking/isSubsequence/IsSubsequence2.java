package cn.meow.greedyThinking.isSubsequence;

public class IsSubsequence2 {

    /**
     * 动态规划
     * 同时我们注意到, 该解法中对 t 的处理与 s 无关, 且预处理完成后，可以利用预处理数组的信息,
     * 线性地算出任意一个字符串 s 是否为 t 的子串
     * 这样我们就可以解决「后续挑战」
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] f = new int[m + 1][26];
        //对数组初始化
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        //针对t进行预处理
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    //如果相等就是当前行的值
                    f[i][j] = i;
                } else {
                    //否则就是前一行的值(即前一次遍历的行)
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < n; i++) {
            //如果是预设的值, 即不存在该字符
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            //跳行
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    /**
     * 简洁
     */
    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
