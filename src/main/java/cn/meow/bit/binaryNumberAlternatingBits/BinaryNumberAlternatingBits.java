package cn.meow.bit.binaryNumberAlternatingBits;

public class BinaryNumberAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        if (n < 0) {
            return false;
        }
        //获取最高位的1所在二进制的值
        int bit = Integer.highestOneBit(n);
        //最高位的1在第几位
        int height = (int) (Math.log(bit)/Math.log(2.0));
        //获取第一位
        int pre = n & 1;
        n >>= 1;
        for (int i = 1; i <= height; i++) {
            //比较前一位是否与当前位相等
            if ((n & 1) == pre) {
                return false;
            }
            pre = n & 1;
            n >>= 1;
        }
        return true;
    }
}
