package cn.meow.array.findDuplicateNum;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNum {

    /**
     * 二分
     * 例如: 1 2 2 3
     * mid=2 小于等于2的理应cnt只有2个,实际是3个
     * 即落在[1,2]之间
     */
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * hash
     * 不符合题意,超过常量级 O(1) 的额外空间
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
