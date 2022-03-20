package cn.meow.greedythinking.nondecreasingarray;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        //是否改变过
        boolean isDele = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (isDele) {
                    return false;
                }
                isDele = true;

                //          i  i+1
                //例如:  3   4   2   3

                //删i
                if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                    //删i+1
                    if (i + 2 < nums.length && nums[i] > nums[i + 2]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
