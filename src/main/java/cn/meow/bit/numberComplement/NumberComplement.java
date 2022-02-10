package cn.meow.bit.numberComplement;

public class NumberComplement {

    public int findComplement(int num) {
        int result = 0;
        //获取最高位的1所在二进制的值
        int bit = Integer.highestOneBit(num);
        //最高位的1在第几位
        int height = (int) (Math.log(bit) / Math.log(2.0));
        for (int i = 0; i <= height; i++) {
            if ((num & 1) == 0) {
                result |= (1 << i);
            }
            num >>= 1;
        }
        return result;
    }
}
