package cn.meow.plan.algorithm.threshold.stringpermutation;

public class StringPermutation2 {

    public boolean checkInclusion(String s1, String s2) {
        //s1
        char[] pattern = s1.toCharArray();
        //s2
        char[] text = s2.toCharArray();

        //s1长度
        int pLen = s1.length();
        //s2长度
        int tLen = s2.length();

        //存放s1出现字母的次数
        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        //计算s1每个字母的次数
        for (int i = 0; i < pLen; i++) {
            pFreq[pattern[i] - 'a']++;
        }

        //计算s1有多少个不同的字母 类型数
        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] > 0) {
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        // 当滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
        int winCount = 0;
        while (right < tLen) {
            //s1中是否存在这个字母
            if (pFreq[text[right] - 'a'] > 0) {
                winFreq[text[right] - 'a']++;
                //当s2当前字母等于s1的此字母, winCount+1
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']) {
                    winCount++;
                }
            }
            //窗口右边界+1 end
            right++;

            //s1 和 s2 类型数一样的时候
            while (pCount == winCount) {
                //窗口框住的范围刚好等于 s1 的长度
                if (right - left == pLen) {
                    return true;
                }
                if (pFreq[text[left] - 'a'] > 0) {
                    //减去s2当前的字母次数
                    winFreq[text[left] - 'a']--;
                    //字母数不匹配了, winCount-1
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']) {
                        winCount--;
                    }
                }
                //窗口左边界+1 start
                left++;
            }
        }
        return false;
    }
}
