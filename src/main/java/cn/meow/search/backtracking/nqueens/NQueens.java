package cn.meow.search.backtracking.nqueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        //行
        boolean[] row = new boolean[n];
        //列
        boolean[] col = new boolean[n];
        //45 度对角线标记数组的长度为 2 * n - 1，通过下图可以明确 (i, j) 的位置所在的数组下标为 i + j
        boolean[] diagonal45 = new boolean[2 * n - 1];
        //135 度对角线标记数组的长度也是 2 * n - 1，(i, j) 的位置所在的数组下标为 n - 1 - (i - j)
        boolean[] diagonal135 = new boolean[2 * n - 1];
        char[][] chars = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        //初始化
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                chars[i][j] = '.';
            }
        }
        backtracking(row, col, diagonal45, diagonal135, chars, result, n, 0);
        return result;
    }

    private void backtracking(boolean[] row, boolean[] col, boolean[] diagonal45, boolean[] diagonal135, char[][] chars, List<List<String>> result, int n, int i) {
        //终止条件
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : chars) {
                list.add(new String(c));
            }
            result.add(list);
            return;
        }
        //遍历列
        for (int j = 0; j < n; j++) {
            int diagonal45Index = i + j;
            int diagonal135Index = n - 1 - (i - j);
            if (!row[i] && !col[j] && !diagonal45[diagonal45Index] && !diagonal135[diagonal135Index]) {
                //处理节点
                chars[i][j] = 'Q';
                row[i] = true;
                col[j] = true;
                diagonal45[diagonal45Index] = true;
                diagonal135[diagonal135Index] = true;
                //递归
                backtracking(row, col, diagonal45, diagonal135, chars, result, n, i + 1);
                //回溯
                chars[i][j] = '.';
                row[i] = false;
                col[j] = false;
                diagonal45[diagonal45Index] = false;
                diagonal135[diagonal135Index] = false;
            }
        }
    }
}
