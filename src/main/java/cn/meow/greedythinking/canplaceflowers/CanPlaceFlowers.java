package cn.meow.greedythinking.canplaceflowers;

public class CanPlaceFlowers {

    /**
     * 贪心
     * 只要前面和后面是0就种下
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > 0 && (flowerbed == null || flowerbed.length == 0)) {
            return false;
        }
        if ((flowerbed[0] == 0 && n <= 1 && flowerbed.length == 1) || n == 0) {
            return true;
        }
        //第一个位置
        if (flowerbed[0] == 0 && flowerbed.length >= 2 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        for (int i = 1; i < flowerbed.length - 1 && n > 0; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        //最后一个位置
        if (n > 0 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            //flowerbed[flowerbed.length - 1] = 1;
            n--;
        }
        return n == 0;
    }
}
