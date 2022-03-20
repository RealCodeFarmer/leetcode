package cn.meow.array.kthsmallelesortmatrix;

import java.util.PriorityQueue;

public class KthSmallEleSortMatrix2 {

    /**
     * 二分查找
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        //矩阵最小值
        int left = matrix[0][0];
        //矩阵最大值
        int right = matrix[m - 1][n - 1];
        while (left <= right) {
            //拟定中间值
            int mid = left + (right - left) / 2;
            //记录比mid小的值
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) {
                //比目标数量小, 向右走
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 堆
     */
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            PriorityQueue<Tuple> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                pq.offer(new Tuple(0, j, matrix[0][j]));
            }
            for (int i = 0; i < k - 1; i++) {
                //小根堆, 去掉 k-1 个堆顶元素, 此时堆顶元素就是第 k 的数
                Tuple t = pq.poll();
                if (t.x == m - 1) {
                    continue;
                }
                pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
            return pq.poll().val;
        }

        class Tuple implements Comparable<Tuple> {
            int x;
            int y;
            int val;

            public Tuple(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }

            @Override
            public int compareTo(Tuple that) {
                return this.val - that.val;
            }
        }
    }
}
