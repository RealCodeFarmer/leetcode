package cn.meow.search.backtracking.sudokuSolver;

public class SudokuSolver2 {
    //行列块
    private boolean[][] rowsUsed = new boolean[9][10];
    private boolean[][] colsUsed = new boolean[9][10];
    private boolean[][] cubesUsed = new boolean[9][10];
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        //初始化
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                rowsUsed[i][num] = true;
                colsUsed[j][num] = true;
                cubesUsed[cubeNum(i, j)][num] = true;
            }
        }
        backtracking(0, 0);
    }

    private boolean backtracking(int row, int col) {
        //是否没到行末 并且 为数字
        while (row < 9 && board[row][col] != '.') {
            //找到下一个空的位置
            row = col == 8 ? row + 1 : row;
            col = col == 8 ? 0 : col + 1;
        }
        //终止条件
        if (row == 9) {
            return true;
        }
        ////可填入的数字为1-9
        for (int num = 1; num <= 9; num++) {
            //行列块 使用过这个数
            if (rowsUsed[row][num] || colsUsed[col][num] || cubesUsed[cubeNum(row, col)][num]) {
                continue;
            }
            //处理节点
            rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = true;
            board[row][col] = (char) (num + '0');
            //递归
            if (backtracking(row, col)) {
                return true;
            }
            //回溯
            board[row][col] = '.';
            rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = false;
        }
        return false;
    }

    /**
     * 返回[i,j]在第几块
     */
    private int cubeNum(int i, int j) {
        int r = i / 3;
        int c = j / 3;
        return r * 3 + c;
    }
}
