package cn.meow.bit.singlenumber3;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        //两个不同数的异或结果
        int twoNumbersSum = 0;
        for (int num : nums) {
            twoNumbersSum ^= num;
        }
        //最右边的1在第几位, 即两个数最先开始不同的位(两个数的位相同才为0)
        int n = twoNumbersSum & (~twoNumbersSum + 1);
        //按照(最先开始不同的位)对所有数进行分组
        for (int num : nums) {
            if ((num & n) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
