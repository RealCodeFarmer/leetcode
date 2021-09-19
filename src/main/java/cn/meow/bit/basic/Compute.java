package cn.meow.bit.basic;

public class Compute {

    public static void main(String[] args) {
        //0s 表示一串 0, 1s 表示一串 1
        int x = 0;
        x = x ^ 0b0000;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(~x));
        //利用 x ^ 1s = ~x 的特点，可以将一个数的位级表示翻转
        x = x ^ 0b11111111111111111111111111111111;
        System.out.println(Integer.toBinaryString(x));
        //利用 x ^ x = 0 的特点，可以将三个数中重复的两个数去除，只留下另一个数
        System.out.println(1 ^ 1 ^ 2);
        //利用 x & 0s = 0 和 x & 1s = x 的特点，可以实现掩码操作
        int num1 = 0b01011011;
        int num2 = 0b00111100;
        System.out.println(Integer.toBinaryString(num1 & num2));
        //利用 x | 0s = x 和 x | 1s = 1s 的特点，可以实现设值操作
        int num3 = 0b01011011;
        int num4 = 0b00111100;
        System.out.println(Integer.toBinaryString(num3 | num4));
        //n&(n-1) 去除 n 的位级表示中最低的那一位 1
        int num5 = 0b01011011;
        System.out.println(Integer.toBinaryString(num5 & (num5 - 1)));
        //n&(-n) 得到 n 的位级表示中最低的那一位 1
        //-n 得到 n 的反码加 1，也就是 -n=~n+1
        int num6 = 0b10110100;
        System.out.println(Integer.toBinaryString(num6 & (~num6 + 1)));
        //>>n 算术右移, 相当于除以 2^n
        //>>>n 无符号右移, 左边会补上 0

        //只有第 i 位为 1 的 mask，将 1 向左移动 i-1 位即可，1<<(i-1)
        int num7 = 1 << 4;
        System.out.println(Integer.toBinaryString(num7));
        // 1 到 i 位为 1 的 mask，(1<<i)-1 即可
        int num8 =(1<<4)-1;
        System.out.println(Integer.toBinaryString(num8));
        // 1 到 i 位为 0 的 mask，只需将 1 到 i 位为 1 的 mask 取反，即 ~((1<<i)-1)
        int num9 =~((1<<4)-1);
        System.out.println(Integer.toBinaryString(num9));

        int num10 =0b1111;
        System.out.println("统计 1 的数量: "+Integer.bitCount(num10));
        System.out.println("获得最高位: "+Integer.highestOneBit(num10));// 1000 => 8
        System.out.println("转换为二进制表示的字符串: "+Integer.toBinaryString(num10));
    }
}
