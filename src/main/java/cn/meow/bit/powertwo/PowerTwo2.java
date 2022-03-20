package cn.meow.bit.powertwo;

public class PowerTwo2 {

    /**
     * 二进制表示只有一个 1 存在
     */
    public boolean isPowerOfTwo(int n) {
        //Integer.bitCount(x) 返回指定int值的二进制补码表示形式中1位的个数
        return n > 0 && Integer.bitCount(n) == 1;
    }

    /**
     * 利用 1000 & 0111 == 0 这种性质，得到以下解法
     */
    public boolean isPowerOfTwo2(int n) {
        //1000 & 0111 == 0
        //即最高位的1也是最低位的1,也就只有一个1
        return n > 0 && (n & (n - 1)) == 0;
    }
}
