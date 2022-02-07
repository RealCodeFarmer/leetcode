package cn.meow.bit.basic;

import java.util.function.IntConsumer;

public class Expand {

    public static void main(String[] args) {
        //程序员代码面试指南 ：P317
        int a = 12;
        int b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        //b = a ^ b ^ b
        //a = a* ^ b*  => (a* = a ^ b) (b* = a ^ b ^ b)  即 a = a ^ b ^ a ^ b ^ b
        System.out.println(a);
        System.out.println(b);
    }
}
