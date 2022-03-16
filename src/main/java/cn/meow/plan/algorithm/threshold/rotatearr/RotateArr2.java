package cn.meow.plan.algorithm.threshold.rotatearr;

public class RotateArr2 {

    /**
     * 使用额外的数组
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 环状替换
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                //交换
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    /**
     * 最大公约数
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /**
     * 数组翻转
     * 原始数组 1 2 3 4 5 6 7
     * 翻转所有元素   7 6 5 4 3 2 1
     * 翻转 [0, k mod n - 1] 区间的元素    5 6 7 4 3 2 1
     * 翻转 [k mod n, n−1] 区间的元素  5 6 7 1 2 3 4
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
