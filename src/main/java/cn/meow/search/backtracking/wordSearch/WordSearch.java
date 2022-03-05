package cn.meow.search.backtracking.wordSearch;

public class WordSearch {
    private boolean[][] isVisit;
    private int m, n;
    private int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        isVisit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int curLength, int i, int j) {
        //终止条件
        if (curLength == word.length()) {
            return true;
        }
        //处理节点
        if (i < 0 || i >= m || j < 0 || j >= n
                || board[i][j] != word.charAt(curLength) || isVisit[i][j]) {
            return false;
        }
        isVisit[i][j] = true;
        for (int[] d : direction) {
            //递归操作backtracking(board, word, 0, i, j)
            if (backtracking(board, word, curLength + 1, i + d[0], j + d[1])) {
                return true;
            }
        }
        //回溯
        isVisit[i][j] = false;
        return false;
    }
}
