package cn.meow.bit.powerFour;

public class PowerFour {

    public boolean isPowerOfFour(int n) {
        //奇数位仅有一个1
        boolean isExistOne = false;
        if (n < 0) {
            return false;
        }
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                if (i % 2 == 1 || isExistOne) {
                    return false;
                }
                isExistOne = true;
            }
            n >>= 1;
        }
        return isExistOne;
    }
}
