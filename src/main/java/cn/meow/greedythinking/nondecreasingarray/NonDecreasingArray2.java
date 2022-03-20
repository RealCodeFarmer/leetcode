package cn.meow.greedythinking.nondecreasingarray;

public class NonDecreasingArray2 {

    /**
     * 在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，使得本次修改能使 i 之前的数组成为非递减数组，并且 不影响后续的操作
     * 优先考虑令 nums[i - 1] = nums[i]，因为如果修改 nums[i] = nums[i - 1] 的话，那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，从
     * 而影响了后续操作。还有一个比较特别的情况就是 nums[i] < nums[i - 2]，修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，只能修改nums[i] = nums[i - 1]
     */
    public boolean checkPossibility(int[] nums) {
        //删掉的个数
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            //如果是递增,继续循环
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            //否则,cnt++
            cnt++;
            //如果 i-2>i, 即删除这个位置可行, 让i = i-1, 即删除i
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
