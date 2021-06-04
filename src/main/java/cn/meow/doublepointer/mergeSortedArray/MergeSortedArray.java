package cn.meow.doublepointer.mergeSortedArray;

import java.util.Arrays;

public class MergeSortedArray {

    /**
     * 合并之后再排序
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //合并
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }
        //排序
        Arrays.sort(nums1);
    }
}
