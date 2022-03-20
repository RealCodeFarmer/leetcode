package cn.meow.array.beautifularrangement2;

public class BeautifulArrangementII {

    /*public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        int cnt = k / 2;
        int index = 1;
        if (cnt != 0) {
            int temp = result[n - 1];
            for (int i = n - 1; i > index; i--) {
                result[i] = result[i - 1];
            }
            result[index] = temp;
            index += 2;
            cnt--;
        }
        if (k!=1 && k % 2 == 1) {
            //最后一位拉到第一位
            int temp = result[n - 1];
            for (int i = n - 1; i > 0; i--) {
                result[i] = result[i - 1];
            }
            result[0] = temp;
        }
        return result;
    }*/
}
