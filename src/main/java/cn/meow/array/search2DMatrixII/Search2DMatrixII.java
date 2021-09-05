package cn.meow.array.search2DMatrixII;

public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            for (int i : ints) {
                if (i == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
