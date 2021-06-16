package cn.meow.binarySearch.findMinimumInRotated;

public class FindMinimumInRotated2 {

    /**
     * 二分查找
     * 描点画图分析图像
     * nums[mid]<nums[high], 数组是升序, 说明mid到high没有受到旋转的影响, 右半部分可以忽略, 最小值不在右半边
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                //与标准的二分查找不同, 一般二分是找一个确确的数是否存在, 存在就返回
                //这里是个未知数x(数组中的最小值,一定存在), 所以mid有可能是最小值, 所以不用high=mid-1
                high = mid;
            } else {
                //这里不是low=mid是因为, 如果mid是最小值就必不可能>nums[high]
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
