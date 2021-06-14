package cn.meow.binarySearch.sqrtX;

public class SqrtX2 {

    /**
     * 二分查找
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * 袖珍计算器算法
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        //√X = e^(1/2lnX)
        int ans = (int) Math.exp(0.5 * Math.log(x));
        //计算机无法存储浮点数的精确值, 运算过程中会存在误差, 应当找出 ans 与 ans+1 中哪一个是真正的答案
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    /**
     * 牛顿迭代法
     * 快速求解函数零点的方法, 数学法没太懂
     * 牛顿求根法公式推导: BV1Nt411T7HT(B站)  公式=>X(n+1)=X(n)-f(X(n))/f'(X(n))
     */
    class Solution {
        int s;

        public int mySqrt(int x) {
            s = x;
            if (x == 0) return 0;
            return ((int) (sqrts(x)));
        }

        //f(x)=x^2-a=0 函数上任一点 (x,f(x)) 处的切线斜率是 2x
        //那么，x-f(x)/(2x) 就是一个比 x 更接近的近似值
        //代入 f(x)=x^2-a 得到 x-(x^2-a)/(2x) => (x+a/x)/2
        public double sqrts(double x) {
            double res = (x + s / x) / 2;
            if (res == x) {
                return x;
            } else {
                return sqrts(res);
            }
        }
    }
}
