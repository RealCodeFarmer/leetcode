package cn.meow.binarySearch.findMinimumInRotated;

public class FindMinimumInRotated {

    /**
     * 二分查找
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 0) {
            return -65535;
        }
        if (nums.length <= 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int result = nums[0];
        while (true) {
            int mid = left + (right - left) / 2;
            mid = (mid + nums.length) % nums.length;
            if (nums[(mid - 1 + nums.length) % nums.length] > nums[mid]) {
                //如果左边比它大
                result = nums[mid];
                break;
            } else {
                //如果左边比它小
                right = (mid - 1 + nums.length) % nums.length;
                left = (left - 1 + nums.length) % nums.length;
            }
        }
        return result;
    }
}
