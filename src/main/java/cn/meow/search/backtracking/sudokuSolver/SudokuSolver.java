package cn.meow.search.backtracking.sudokuSolver;

public class SudokuSolver {
    private boolean solver = false;

    /**
     * 方块索引: (行/3)*3 + 列/3
     */
    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }
        //行
        int[][] row = new int[9][9];
        //列
        int[][] col = new int[9][9];
        //块
        int[][] block = new int[9][9];
        //初始化
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                //空白格用 '.' 表示
                if (c == '.') {
                    continue;
                }
                row[i][c - '0' - 1] = 1;
                col[j][c - '0' - 1] = 1;
                block[(i / 3) * 3 + j / 3][c - '0' - 1] = 1;
            }
        }
        backtracking(board, row, col, block, 0, 0);
    }

    private void backtracking(char[][] board, int[][] row, int[][] col, int[][] block, int i, int j) {
        //终止条件
        if (i == 9) {
            solver = true;
            return;
        }
        //如果有数字
        if (board[i][j] != '.') {
            //还没到列的最后
            if (j < 8) {
                backtracking(board, row, col, block, i, j + 1);
            } else {
                //最后一列了,换行开始
                backtracking(board, row, col, block, i + 1, 0);
            }
        } else {
            int blockNo = (i / 3) * 3 + j / 3;
            //可填入的数字为1-9
            for (int k = 1; k <= 9; k++) {
                //行列块都没有使用过这个数,设置进去
                if (row[i][k - 1] == 0 && col[j][k - 1] == 0 && block[blockNo][k - 1] == 0) {
                    //处理节点
                    board[i][j] = (char) (k + '0');
                    row[i][k - 1] = 1;
                    col[j][k - 1] = 1;
                    block[blockNo][k - 1] = 1;
                    //递归
                    if (j < 8) {
                        backtracking(board, row, col, block, i, j + 1);
                    } else {
                        backtracking(board, row, col, block, i + 1, 0);
                    }
                    //回溯
                    if (!solver) {
                        board[i][j] = '.';
                        row[i][k - 1] = 0;
                        col[j][k - 1] = 0;
                        block[blockNo][k - 1] = 0;
                    }
                }
            }
        }
    }
}
