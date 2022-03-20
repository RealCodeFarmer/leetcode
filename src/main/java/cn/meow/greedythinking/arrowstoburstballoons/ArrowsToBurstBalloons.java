package cn.meow.greedythinking.arrowstoburstballoons;

import java.util.Arrays;
import java.util.Comparator;

public class ArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                //return o1[0] - o2[0];
                return o1[0] > o2[0] ? 1 : (o1[0] == o2[0] ? 0 : -1);
            }
        });

        int result = 1;
        //参考系
        int[] referenceFrame = points[0];
        for (int i = 1; i < points.length; i++) {
            //超出参考系
            if (points[i][0] > referenceFrame[1]) {
                result++;
                referenceFrame = points[i];
                continue;
            }
            //重新计算参考系 例如: [0,9][3,12] 参考系=>[3,9]
            referenceFrame[0] = points[i][0] >= referenceFrame[0] ? points[i][0] : referenceFrame[0];
            referenceFrame[1] = points[i][1] <= referenceFrame[1] ? points[i][1] : referenceFrame[1];
        }
        return result;
    }
}
