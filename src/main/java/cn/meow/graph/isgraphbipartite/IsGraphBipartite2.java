package cn.meow.graph.isgraphbipartite;

import java.util.Arrays;

public class IsGraphBipartite2 {

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        //数组默认值放置 -1
        Arrays.fill(colors, -1);
        // 处理图不是连通的情况
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !isBipartite(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (!isBipartite(nextNode, 1 - curColor, colors, graph)) {
                return false;
            }
        }
        return true;
    }
}
