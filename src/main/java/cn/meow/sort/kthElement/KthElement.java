package cn.meow.sort.kthElement;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 */
public class KthElement {

    /**
     * 第k趟冒泡
     */
    public int findKthLargest(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = nums[0];
            int maxIndex = 0;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    maxIndex = j;
                }
            }
            //把找到的最大数跟数组"最后一位"(nums.length - i - 1)换位
            int temp = nums[nums.length - i - 1];
            nums[maxIndex] = temp;
            nums[nums.length - i - 1] = max;
        }
        return max;
    }
}
