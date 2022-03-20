package cn.meow.doublepointer.sumofsquarenumbers;

public class SumOfSquareNumbers {

    /**
     * 暴力枚举
     * 超时
     */
    public boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1) {
            return true;
        }
        for (long head = 0; head <= c / 2; head++) {
            if (head * head > c) {
                break;
            }
            for (long tail = head; tail <= c / 2; tail++) {
                long result = head * head + tail * tail;
                if (result == c) {
                    return true;
                } else if (result > c) {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * sqrt函数
     */
    public boolean judgeSquareSum2(int c) {
        for (long head = 0; head <= c; head++) {
            if (head * head > c) {
                break;
            }
            double sqrt = Math.sqrt(c - head * head);
            //判断开方是否为整数
            //1. math.sqrt(x) % 1 == 0
            //2. sqrt == (int) sqrt
            if (sqrt % 1 == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     */
    public boolean judgeSquareSum3(int c) {
        int head = 0;
        int tail = (int) Math.sqrt(c);
        while (head <= tail) {
            long result = head * head + tail * tail;
            if (result == c) {
                return true;
            } else if (result > c) {
                tail--;
            } else {
                head++;
            }
        }
        return false;
    }
}
