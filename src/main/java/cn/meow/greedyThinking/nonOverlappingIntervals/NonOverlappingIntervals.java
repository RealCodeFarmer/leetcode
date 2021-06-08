package cn.meow.greedyThinking.nonOverlappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 */
public class NonOverlappingIntervals {


    /**
     * 没做出来
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;

        //先排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.valueOf(o1[1] - o1[0]).compareTo(o2[1] - o2[0]);
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] newArr : intervals) {
            boolean bool = true;
            for (int i = 0; i < list.size(); i++) {
                int[] ints = list.get(i);
                if ((ints[0] == newArr[0] && ints[1] == newArr[1])
                        || ints[0] <= newArr[0] && ints[1] > newArr[0]
                        || (ints[0] >= newArr[0] && ints[0] < newArr[1])) {
                } else {
                    result++;
                    bool = false;
                    break;
                }
            }
            if (bool) {
                list.add(newArr);
            }
        }
        return intervals.length - result;
    }
}
