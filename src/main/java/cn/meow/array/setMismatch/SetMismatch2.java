package cn.meow.array.setMismatch;

import java.util.Arrays;

public class SetMismatch2 {

    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //当前位置不争取, 且前一个位置也不等于它
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                //把它放回正确的位置, 即值-1(index:n,val:n+1)
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 排序
     */
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] result = new int[2];
            int n = nums.length;
            Arrays.sort(nums);
            int prev = 0;
            for (int i = 0; i < n; i++) {
                int curr = nums[i];
                if (curr == prev) {
                    //重复出现
                    result[0] = prev;
                } else if (curr - prev > 1) {
                    //前后相差超过1
                    result[1] = prev + 1;
                }
                prev = curr;
            }
            //处理最后一个数被换成错误数的情况
            if (nums[n - 1] != n) {
                result[1] = n;
            }
            return result;
        }
    }
}
