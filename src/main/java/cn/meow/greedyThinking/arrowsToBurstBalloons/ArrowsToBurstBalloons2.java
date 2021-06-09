package cn.meow.greedyThinking.arrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class ArrowsToBurstBalloons2 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //区间的结尾升序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = points[0][1];
        //思路: 箭每次都在极限点(即最后边的点,擦边球)
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
