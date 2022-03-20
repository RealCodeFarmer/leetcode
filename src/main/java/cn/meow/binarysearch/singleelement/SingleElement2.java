package cn.meow.binarysearch.singleelement;

public class SingleElement2 {

    /**
     * 暴力法
     * 因为数组是有序的, 跳着找, 然后两两比较
     */
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 二分查找
     */
    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //mid右边是否为偶
            boolean halvesAreEven = (right - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                //mid+1等于mid, 相当于删掉右边一个
                if (halvesAreEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                //mid-1等于mid, 相当于删掉左边边一个
                if (halvesAreEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    /**
     * 仅对偶数索引进行二分搜索
     */
    public int singleNonDuplicate3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //mid%2==1, 说明mid的左边是奇数列
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
