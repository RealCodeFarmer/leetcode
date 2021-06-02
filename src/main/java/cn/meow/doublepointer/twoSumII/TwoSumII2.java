package cn.meow.doublepointer.twoSumII;

public class TwoSumII2 {

    /**
     * 二分查找法
     * 升序数组
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            int high = numbers.length - 1;
            int residue = target - numbers[i];
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == residue) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > residue) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 双指针
     * 升序数组
     * <p>
     * 加起来比目标数大,那尾指针往右的都比目标数大.尾指针要往左走
     * 加起来比目标数小,那头指针往左的都比目标数小.头指针要往右走
     */
    public int[] twoSum2(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        while (head <= tail) {
            int result = numbers[head] + numbers[tail];
            if (result == target) {
                return new int[]{head + 1, tail + 1};
            } else if (result > target) {
                tail--;
            } else {
                head++;
            }
        }
        return new int[]{-1, -1};
    }
}
