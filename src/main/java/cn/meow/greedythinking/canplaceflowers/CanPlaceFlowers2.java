package cn.meow.greedythinking.canplaceflowers;

public class CanPlaceFlowers2 {

    /**
     * 数学归纳法
     * 对于中间的0区间：
     *      1~2个0：可种0朵
     *      3~4个：可种1朵
     *      5~6个：可种2朵
     *      ...
     *      count个：可种 (count-1)/2 朵
     * <p>
     * 为了代码流程的统一，可以在数组最左边、数组最右边分别补1个0，意味着花坛左边、右边没有花
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) return n == 0;

        int countOfZero = 1; //当前全0区段中连续0的数量，刚开始预设1个0，因为开头花坛的最左边没有花，可以认为存在一个虚无的0
        //可以种的花的数量
        int canPlace = 0;
        for (int bed : flowerbed) {
            if (bed == 0) {
                //遇到0，连续0的数量+1
                countOfZero++;
            } else {
                //遇到1，结算上一段连续的0区间，看能种下几盆花：(countOfZero-1)/2
                canPlace += (countOfZero - 1) / 2;
                if (canPlace >= n) {
                    return true;
                }
                countOfZero = 0; //0的数量清零，开始统计下一个全0分区
            }
        }
        // 最后一段0区还未结算：
        countOfZero++; //最后再预设1个0，因为最后花坛的最右边没有花，可以认为存在一个虚无的0
        canPlace += (countOfZero - 1) / 2;

        return canPlace >= n;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            //如果已种花
            if (flowerbed[i] == 1) {
                continue;
            }
            //第一个位置,前面为虚无的0
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            //最后一个位置,后面为虚无的0
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
