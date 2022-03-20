package cn.meow.greedythinking.partitionlabels;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels2 {

    /**
     * 贪心
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        //把每个字母最后出现的位置索引存起来
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            //找出片段最大索引
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
