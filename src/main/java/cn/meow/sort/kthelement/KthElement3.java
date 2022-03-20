package cn.meow.sort.kthelement;

public class KthElement3 {

    /**
     * 基于堆排序的选择方法
     */
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            //根结点跟最后一个元素交换 即最大跟最小交换
            swap(nums, 0, i);
            --heapSize;
            //然后进行一次堆排序,得到新的大顶堆
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    /**
     * 创建大顶堆
     */
    public void buildMaxHeap(int[] a, int heapSize) {
        //i=根节点
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        //左孩子
        int left = i * 2 + 1;
        //右孩子
        int r = i * 2 + 2;
        //双亲
        int largest = i;
        //有左孩子并且大于双亲结点
        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }
        //有右孩子并且大于双亲结点
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        //是否需要交换
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
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
