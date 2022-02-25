package cn.meow.search.bfs.wordLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        // 单词数
        int n = wordList.size();
        int start = n - 1;
        // 结位置的索引值
        int end = 0;
        // sk!=endWord
        while (end < n && !wordList.get(end).equals(endWord)) {
            end++;
        }
        // 不在字典中, 返回0
        if (end == n) {
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    /**
     * 创建单词可达数组
     */
    private List<Integer>[] buildGraphic(List<String> wordList) {
        // 单词数
        int n = wordList.size();
        List<Integer>[] graphic = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    /**
     * 两数是否可以转换
     */
    private boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        // 只有一位可变
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        // 标记
        marked[start] = true;
        // 路径长度
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int next : graphic[cur]) {
                    // 最快到达endWord的就是最短路径
                    if (next == end) {
                        return path;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}
