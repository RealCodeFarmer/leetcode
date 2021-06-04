package cn.meow.doublepointer.mergeSortedArray;

public class MergeSortedArray2 {

    /**
     * 双指针
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                //p1已经没有元素的情况
                cur = nums2[p2++];
            } else if (p2 == n) {
                //p2已经没有元素的情况
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                //p1<p2
                cur = nums1[p1++];
            } else {
                //p1>=p2
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        //遍历放进num1中
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 逆向双指针
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //m+n最后一个位置
        int tail = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p2 >= 0) {
            if (p1 < 0 || nums1[p1] <= nums2[p2]) {
                //p1已经没有元素的情况 或者 p1<=p2
                nums1[tail--] = nums2[p2--];
            } else {
                //p1>p2
                nums1[tail--] = nums1[p1--];
            }
        }
    }
}
