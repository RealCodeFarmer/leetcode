package cn.meow.binarySearch.singleElement;

public class SingleElement {

    /**
     * 异或
     */
    public int singleNonDuplicate(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
