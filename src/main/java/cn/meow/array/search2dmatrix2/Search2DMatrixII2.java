package cn.meow.array.search2dmatrix2;

public class Search2DMatrixII2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int curM = 0;
        int curN = n - 1;
        //第一次拿的是第一行的最后一个
        //比它大的, 只能在下一行, 比它小的也只能在同一行的前面
        while (curM < m && curN >= 0) {
            if (target == matrix[curM][curN]) {
                return true;
            } else if (target < matrix[curM][curN]) {
                curN--;
            } else {
                curM++;
            }
        }
        return false;
    }
}
