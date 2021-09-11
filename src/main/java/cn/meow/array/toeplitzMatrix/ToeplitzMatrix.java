package cn.meow.array.toeplitzMatrix;

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        //m*n矩阵 第一行比较n-1个， 后面行只比较第一个
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 0; j < m; j++) {
            int length = 0;
            if (j == 0) {
                //第一行
                length = n - 1;
            } else {
                //其他行
                length = 1;
            }
            for (int i = 0; i < length; i++) {
                int temp = matrix[j][i];
                int curN = i+1;
                int curM = j+1;
                //是否在范围内
                while (curM < m && curN < n) {
                    if (temp != matrix[curM][curN]) {
                        return false;
                    }
                    curM++;
                    curN++;
                }
            }
        }
        return true;
    }
}
