package cn.meow.bit.reversebits;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits2 {

    public class Solution {
        public int reverseBits(int n) {
            int ret = 0;
            for (int i = 0; i < 32; i++) {
                ret <<= 1;
                ret |= (n & 1);
                //>>>   无符号右移, 忽略符号位, 空位都以0补齐
                n >>>= 1;
            }
            return ret;
        }
    }

    /**
     *  如果多次调用这个函数, 优化方式
     *  如果该函数需要被调用很多次, 可以将 int 拆成 4 个 byte, 然后缓存 byte 对应的比特位翻转, 最后再拼接起来
     */
    public static class Solution2 {
        private static Map<Byte, Integer> cache = new HashMap<>();

        public int reverseBits(int n) {
            int ret = 0;
            for (int i = 0; i < 4; i++) {
                ret <<= 8;
                ret |= reverseByte((byte) (n & 0b11111111));
                n >>= 8;
            }
            return ret;
        }

        /**
         * 对一个字节进行翻转
         * @param b 1个字节=8位
         */
        private int reverseByte(byte b) {
            if (cache.containsKey(b)){
                return cache.get(b);
            }
            int ret = 0;
            byte t = b;
            for (int i = 0; i < 8; i++) {
                ret <<= 1;
                ret |= t & 1;
                t >>= 1;
            }
            cache.put(b, ret);
            return ret;
        }
    }
}
