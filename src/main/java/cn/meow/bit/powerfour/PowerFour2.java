package cn.meow.bit.powerfour;

public class PowerFour2 {

    /**
     * 这种数在二进制表示中有且只有一个奇数位为 1，例如 16（10000）
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }

    /**
     * 正则表达式进行匹配
     */
    public boolean isPowerOfFour2(int num) {
        //toString(int i, int radix) 返回由第二个参数指定的基数中的第一个参数的字符串表示形式
        //* 零次或多次匹配前面的字符或子表达式
        return Integer.toString(num, 4).matches("10*");
    }
}
