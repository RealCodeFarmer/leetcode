package cn.meow.binarySearch.findMinimumInRotated;

public class FindMinimumInRotated2 {

    /**
     * 二分查找
     * 描点画图分析图像
     * nums[pivot]<nums[high], 数组是升序, 说明pivot到high没有受到旋转的印象, 右半部分可以忽略, 最小值不在右半边
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
