package cn.meow.binarysearch.findfirstlastpositionelement;

public class FindFirstLastPositionElement {

    /**
     * 二分查找
     */
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int end = -1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                first = mid;
                end = mid;
                break;
            }
        }

        if (first != -1) {
            //往左边找
            while (first - 1 >= 0 && nums[first - 1] == target) {
                first--;
            }
            //往右边找
            while (end + 1 < nums.length && nums[end + 1] == target) {
                end++;
            }
        }
        return new int[]{first, end};
    }
}
