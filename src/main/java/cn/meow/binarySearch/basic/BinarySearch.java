package cn.meow.binarySearch.basic;

public class BinarySearch {

    public int binarySearch(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            //有两种计算中值 m 的方式: m=(l+h)/2; m=l+(h-l)/2;
            //(l+h) 可能出现加法溢出, 但是 l 和 h 都为正数，因此 (h-l) 不会出现加法溢出问题
            int mid = low + (high - low) / 2;
            if (key < nums[mid]) {
                high = mid - 1;
            } else if (key > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 变种
     */
    public int binarySearch2(int[] nums, int key) {
        int low = 0;
        int high = nums.length;
        //如果条件为 l <= h 时循环无法退出的情况
        //nums={0, 1, 2}; key=1
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        //当循环体退出时，不表示没有查找到 key
        //为了验证有没有查找到, 需要在调用端判断一下返回位置上的值和 key 是否相等
        return low;
    }
}
