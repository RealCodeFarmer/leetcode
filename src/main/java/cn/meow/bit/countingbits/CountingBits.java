package cn.meow.bit.countingbits;

public class CountingBits {

    /**
     * 例如：
     * pre:0110=>2 next:0111=>3
     * pre:0111=>3 next:1000=>1
     * <p>
     * 思路:
     * 前一个ans的数量减去 从后数有多少个连续的1 ,再加上进位的1
     * ans[i] = ans[i - 1] - cnt + 1
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int pre = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            int temp = pre;
            while ((temp & 1) == 1) {
                cnt++;
                temp >>= 1;
            }
            ans[i] = ans[i - 1] - cnt + 1;
            pre = i;
        }
        return ans;
    }
}
