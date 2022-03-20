package cn.meow.binarysearch.sqrtx;

public class SqrtX {

    /**
     * 遍历
     */
    public int mySqrt(int x) {
        int result = -1;
        for (int i = 0; i < (x / 2) + 2; i++) {
            int val = i * i;
            //题意: 计算并返回 x 的平方根，其中 x 是非负整数
            //为负数,肯定是正数溢出了
            if (val >= 0 && val <= x) {
                result = i;
            } else {
                break;
            }
        }
        return result;
    }
}