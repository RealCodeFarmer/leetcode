package cn.meow.plan.algorithm.threshold.minimumpathsumtriangle;

import java.util.List;

public class MinimumPathSumTriangle {

    /**
     * 贪心,没法找到全局最优
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = 0;
        int pre = 0;
        for (List<Integer> list : triangle) {
            int min;
            if (pre + 1 < list.size() && list.get(pre) > list.get(pre + 1)) {
                min = list.get(pre + 1);
                pre += 1;
            } else {
                min = list.get(pre);
            }
            result += min;
        }
        return result;
    }

    /**
     * dp
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] triangleArr = new int[size][size];
        //将 triangle 转换为数组 triangleArr
        for (int i = 0; i < size; i++) {
            int len = triangle.get(i).size();
            for (int j = 0; j < len; j++) {
                //从第二层开始
                int min = 0;
                if (i >= 1) {
                    if (j - 1 >= 0 && j - 1 < len - 1 && j < len - 1) {
                        //都不为空的情况,不存在都为空的情况
                        min = Math.min(triangleArr[i - 1][j], triangleArr[i - 1][j - 1]);
                    } else if (j < len - 1) {
                        //上一个j 不为空
                        min = triangleArr[i - 1][j];
                    } else {
                        //上一个(j-1) 不为空
                        min = triangleArr[i - 1][j - 1];
                    }
                }
                triangleArr[i][j] = triangle.get(i).get(j) + min;
            }
        }
        int result = triangleArr[size - 1][0];
        //遍历最后一层的最小值
        for (int i = 1; i < triangleArr[size - 1].length; i++) {
            if (result > triangleArr[size - 1][i]) {
                result = triangleArr[size - 1][i];
            }
        }
        return result;
    }
}
