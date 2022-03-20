package cn.meow.plan.algorithm.threshold.longestsubstring;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        //英文字母、数字、符号和空格
        int[] lastIndexs = new int[128];
        for (int i = 0; i < lastIndexs.length; i++) {
            lastIndexs[i] = -1;
        }
        //最大子串数
        int result = 0;
        //当前子串数
        int index = 0;
        //当前子串开始位置
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //已经访问过
            if (lastIndexs[c] != -1) {
                //控制开始的位置
                start = Math.max(lastIndexs[c], start);
                index = i - start;
            }
            //更新最后出现的位置
            lastIndexs[c] = i;
            index++;
            result = Math.max(index, result);
        }
        return result;
    }
}
