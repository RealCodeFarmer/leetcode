package cn.meow.sort.sortColors;

public class SortColors2 {

    /**
     * 二次遍历
     */
    public void sortColors(int[] nums) {
        int pro = 0;
        //将0归位
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, pro);
                pro++;
            }
        }
        //将1归位
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, pro);
                pro++;
            }
        }
    }

    /**
     * 一次遍历
     */
    public void sortColors2(int[] nums) {
        int length = nums.length;
        //左指针 即"0"的位置开始
        int left = 0;
        //右指针 即"2"的位置结束
        int right = length - 1;
        int i = left;

        //i从左往右走 , 与右边指针重合循环停止
        while (i <= right) {
            if (nums[i] == 2) {
                swap(nums, i, right--);
            } else if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else {
                i++;
            }
        }
    }

    /**
     * 交换两个元素
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
