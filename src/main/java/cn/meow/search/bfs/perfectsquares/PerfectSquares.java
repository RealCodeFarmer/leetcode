package cn.meow.search.bfs.perfectsquares;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares {

    public int numSquares(int n) {
        if (n < 0) {
            return -1;
        }
        int sqrt = (int) Math.sqrt(n);
        List<Integer> squares = generateSquares(sqrt);
        Queue<Integer> queue = new LinkedList<>();
        // 记录访问过的
        boolean[] visited = new boolean[n + 1];
        queue.add(n);
        visited[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int cnt = 0; cnt < size; cnt++) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    // 访问过的跳过
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            squares.add(i * i);
        }
        return squares;
    }
}
