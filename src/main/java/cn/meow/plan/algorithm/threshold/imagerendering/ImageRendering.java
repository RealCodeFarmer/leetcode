package cn.meow.plan.algorithm.threshold.imagerendering;

import javafx.util.Pair;

import java.util.Stack;

public class ImageRendering {
    private int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     * 超时
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //m x n 的二维整数数组
        int m = image.length;
        int n = image[0].length;
        //初始像素顔色
        int color = image[sr][sc];
        //栈
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(sr, sc));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pop = stack.pop();
            Integer key = pop.getKey();
            Integer value = pop.getValue();
            //设置新值
            image[key][value] = newColor;
            for (int[] direction : directions) {
                int i = key + direction[0];
                int j = value + direction[1];
                if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != color) {
                    continue;
                }
                stack.add(new Pair<>(i, j));
            }
        }
        return image;
    }
}
