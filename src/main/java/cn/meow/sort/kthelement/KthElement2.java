package cn.meow.sort.kthelement;

import java.util.Random;

public class KthElement2 {
    Random random = new Random();

    /**
     * 基于快速排序的选择方法
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 快速排序思路
     */
    public int quickSelect(int[] a, int left, int r, int index) {
        int q = randomPartition(a, left, r);
        //轴位置 是否 刚好是要找的元素
        if (q == index) {
            return a[q];
        } else {
            //如果不是,判断是在轴的左边还是右边
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, left, q - 1, index);
        }
    }

    /**
     * 返回轴位置索引
     */
    public int randomPartition(int[] a, int left, int r) {
        //随机生成轴索引值
        int i = random.nextInt(r - left + 1) + left;
        swap(a, i, r);
        return partition(a, left, r);
    }

    /**
     * 左边的小于轴,右边的大于轴
     */
    public int partition(int[] a, int left, int r) {
        int x = a[r];
        int i = left - 1;
        for (int j = left; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    /**
     * 交换两个元素
     */
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
