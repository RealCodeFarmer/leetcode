package cn.meow.bit.powertwo;

public class PowerTwo {

    public boolean isPowerOfTwo(int n) {
        boolean isExistOne = false;
        if (n < 0) {
            return false;
        }
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                if (isExistOne) {
                    return false;
                }
                isExistOne = true;
            }
            n >>= 1;
        }
        return isExistOne;
    }
}
