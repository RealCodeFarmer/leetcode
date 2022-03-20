package cn.meow.search.backtracking.palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning2 {

    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        doPartition(s, partitions, tempPartition);
        return partitions;
    }

    private void doPartition(String s, List<List<String>> partitions, List<String> tempPartition) {
        //终止条件 不能再切割
        if (s.length() == 0) {
            partitions.add(new ArrayList<>(tempPartition));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            //是否回文串
            if (isPalindrome(s, 0, i)) {
                //处理节点你
                tempPartition.add(s.substring(0, i + 1));
                //递归 从剩下的部分继续进行切割
                doPartition(s.substring(i + 1), partitions, tempPartition);
                //回溯
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
