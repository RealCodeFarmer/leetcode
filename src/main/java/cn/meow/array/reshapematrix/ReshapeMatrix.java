package cn.meow.array.reshapematrix;

public class ReshapeMatrix {

    /**
     * 大前提矩阵没用上, 就硬解
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null) {
            return null;
        }
        int length = mat.length;
        if (length <= r) {
            //总长度
            int size = 0;
            for (int[] ints : mat) {
                size += ints.length;
            }
            //新空间不够放
            if (r * c < size) {
                return mat;
            }
            //不用放这么多行
            if (size / c < r) {
                return mat;
            }
        }
        int[][] result = new int[r][c];
        int rIndex = 0;
        int cIndex = 0;
        for (int[] ints : mat) {
            for (int i : ints) {
                result[rIndex][cIndex] = i;
                cIndex++;
                if (cIndex == c) {
                    rIndex++;
                    cIndex = 0;
                }
            }
        }
        return result;
    }
}
