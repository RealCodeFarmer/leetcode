package cn.meow.bit.numberComplement;

public class NumberComplement2 {

    /**
     * 对于 00000101，要求补码可以将它与 00000111 进行异或操作
     * 00000101 ^ 00000111 = 00000010
     * 那么问题就转换为求掩码 00000111
     */
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        //0100 0000...0000
        int mask = 1 << 30;
        //101 循环结束等到 100
        while ((num & mask) == 0) {
            mask >>= 1;
        }
        mask = (mask << 1) - 1;
        return num ^ mask;
    }

    /**
     * 利用 Java 的 Integer.highestOneBit() 方法来获得含有首 1 的数
     */
    public int findComplement2(int num) {
        if (num == 0) {
            return 1;
        }
        int mask = Integer.highestOneBit(num);
        mask = (mask << 1) - 1;
        return num ^ mask;
    }

    /**
     * 对于 1000 0000 这样的数要扩展成 1111 1111
     * 例如:
     * mask : 1000 0000
     * mask |= mask >> 1  =>  11000000
     * mask |= mask >> 2  =>  11110000
     * mask |= mask >> 4  =>  11111111
     */
    public int findComplement3(int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return num ^ mask;
    }
}
