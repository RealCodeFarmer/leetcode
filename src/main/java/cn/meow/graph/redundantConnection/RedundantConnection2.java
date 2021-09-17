package cn.meow.graph.redundantConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RedundantConnection2 {

    public int[] findRedundantConnection(int[][] edges) {
        // 根据题意，二维数组的长度即是顶点的个数
        int nodeNum = edges.length;
        //节点是从1开始计数
        int[] parent = new int[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            //初始化
            parent[i] = i;
        }

        //遍历二维数组的顶点对
        int node1 = 0;
        int node2 = 0;
        for (int i = 0; i < nodeNum; i++) {
            node1 = edges[i][0];
            node2 = edges[i][1];
            // 如果能加入到并查集返回true，否则返回false
            if (!union(parent, node1, node2)) {
                break;
            }
        }
        //产生闭环，输出
        return new int[]{node1, node2};
    }

    /**
     * 合并
     */
    public boolean union(int[] parent, int i, int j) {
        int find1 = find(parent, i);
        int find2 = find(parent, j);
        if (find1 == find2) {
            //已经存在，加入则会产生闭环
            return false;
        }
        //加入并查集
        parent[find(parent, i)] = find(parent, j);
        return true;
    }

    /**
     * 查询
     * 找到index的祖先/代表元素
     */
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
            return parent[index];
        }
        return index;
    }
    /*public int find2(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }*/
}
