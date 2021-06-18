package cn.meow.binarySearch.findFirstLastPositionElement;

public class FindFirstLastPositionElement2 {

    /**
     * 二分查找
     * 满足条件的都写l = mid或者r = mid, mid首先写成l + r >> 1,
     * 如果满足条件选择的是l = mid，那么mid那里就加个1, 写成l + r + 1 >> 1
     * 然后就是else对应的写法l = mid对应r = mid - 1，r = mid对应l = mid + 1
     */
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] ans = new int[]{-1, -1};
        if (length == 0) {
            return ans;
        }

        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[right] != target) {
            return ans;
        }
        ans[0] = right;

        left = 0;
        right = length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        ans[1] = right;

        return ans;
    }

    /**
     * 二分查找
     */
    public int[] searchRange2(int[] nums, int target) {
        int first = findFirst(nums, target);
        //寻找 target+1 第一个位置, 再往前移动一个位置
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    /**
     * h=nums.length;
     * 例如: nums = [2,2], target = 2
     * 如果 h 的取值为 nums.length - 1，那么 last = findFirst(nums,target+1)-1 = 1-1 = 0
     * findLeft 只会返回 [0, nums.length - 1] 范围的值，对于 findFirst([2,2], 3) ，我们希望返回 3 插入 nums 中的位置，也就是数组最后一个位置再往后一个位置，即 nums.length
     * h 取值为 nums.length，从而使得 findFirst返回的区间更大，能够覆盖 target 大于 nums 最后一个元素的情况
     */
    private int findFirst(int[] nums, int target) {
        int left = 0;
        //注意 h 的初始值
        int h = nums.length;
        while (left < h) {
            int mid = left + (h - left) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
