package cn.meow.array.toeplitzMatrix;

public class ToeplitzMatrix2 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        //第一行
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }
        //第一列
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, matrix[i][0], i, 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归比较
     *
     * @param matrix      数组
     * @param expectValue 比较的元素
     * @param row         行
     * @param col         列
     * @return
     */
    private boolean check(int[][] matrix, int expectValue, int row, int col) {
        //判断是否超出范围
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        if (matrix[row][col] != expectValue) {
            return false;
        }
        return check(matrix, expectValue, row + 1, col + 1);
    }
}
