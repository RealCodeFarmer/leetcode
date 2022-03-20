package cn.meow.greedythinking.nonoverlappingintervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals2 {

    /**
     * 可以认为区间的终点总是大于它的起点
     * 思路: 排序从最小而且不想交的结尾开始找最多可以多少个区间
     *      区间结尾越小, 留给后面区间的空间越大, 那么后面能选择的区间个数也越多
     *      结果 = 总长度 - 最多区间数
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //结尾区间升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        //首区间,即最小结尾
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //重叠,跳过此次循环
            if (end > intervals[i][0]) {
                continue;
            }
            count++;
            end = intervals[i][1];
        }
        return intervals.length - count;
    }

    /**
     * 动态规划
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        //结尾区间升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int n = intervals.length;
        int[] f = new int[n];
        //给数组赋默认值1
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // f[i]表示「以区间 i 为最后一个区间，可以选出的区间数量的最大值」
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
