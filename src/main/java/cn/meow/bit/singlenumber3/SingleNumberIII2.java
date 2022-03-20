package cn.meow.bit.singlenumber3;

public class SingleNumberIII2 {

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        //得到最右一位
        diff &= -diff;
        int[] ret = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                ret[0] ^= num;
            } else {
                ret[1] ^= num;
            }
        }
        return ret;
    }
}
