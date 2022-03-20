package cn.meow.array.beautifularrangement2;

public class BeautifulArrangementII2 {

    /**
     * 1 1+(k) 1+(k)-(k-1) ...
     * 1 1+(k) 1+(k)-(k-1) [1+(k)-(k-1)]+(k-1-1)  ...
     * 1 1+k        2                   k         ...
     * 序列为: 1 k+1 2 k 3 k-1 ... k/2 k/2+1
     */
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        //下标k+1的都已经赋值
        //k+2后面的数还没用到
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
