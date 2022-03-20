package cn.meow.graph.isgraphbipartite;

import java.util.LinkedList;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        int length = graph.length;
        //记录颜色 0-相当于没访问过
        int[] color = new int[length];
        //开局先给第一个结点标记为第一种颜色
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            //把没访问过, 并且有连接的结点放进去队列
            if (color[i] == 0 && graph[i].length != 0) {
                queue.offer(i);
                color[i] = 1;
            }
            while (!queue.isEmpty()) {
                //拿到队列中的结点
                Integer element = queue.poll();
                //结点的对立颜色
                int otherColor = color[element] == 1 ? 2 : 1;
                for (int j = 0; j < graph[element].length; j++) {
                    if (color[graph[element][j]] == 0) {
                        //如果没设置, 放入对立颜色
                        color[graph[element][j]] = otherColor;
                        queue.offer(graph[element][j]);
                    } else if (color[graph[element][j]] != otherColor) {
                        //如果设置颜色不对, 返回false
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
