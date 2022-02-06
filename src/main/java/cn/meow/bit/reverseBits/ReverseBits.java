package cn.meow.bit.reverseBits;

public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        //临时变量,可以直接用n
        int temp = n;
        //题意为 32 位无符号整数的二进制位
        for (int i = 0; i < 32; i++) {
            //可以想象成栈,n temp是一个满栈,result是一个空栈
            result <<= 1;
            //这一步相当于peek
            int last = temp & 1;
            //这一步相当于pop
            temp >>= 1;
            result |= last;
        }
        return result;
    }
}
