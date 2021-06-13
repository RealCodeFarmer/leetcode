package cn.meow.greedyThinking.partitionLabels;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    /**
     * 贪心
     * 题意: 划分为尽可能多的片段, 同一字母最多出现在一个片段
     * "贪"每一个字母都能切成一块出来
     */
    public List<Integer> partitionLabels(String s) {
        int tail = s.length() - 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (c != s.charAt(tail)) {
                tail--;
            }
            //把里面有的都拿进来
            tail = maxIndex(s, i, tail);

            result.add(tail - i + 1);
            i = tail;
            tail = s.length() - 1;
        }
        return result;
    }

    /**
     * 计算最大的索引位置
     */
    public int maxIndex(String s, int start, int tail) {
        if (start == tail) {
            return tail;
        }
        for (start += 1; start < tail; start++) {
            for (int i = s.length() - 1; i > tail; i--) {
                if (s.charAt(i) == s.charAt(start)) {
                    if (i > tail) {
                        tail = i;
                    }
                    break;
                }
            }
        }
        return tail;
    }
}
