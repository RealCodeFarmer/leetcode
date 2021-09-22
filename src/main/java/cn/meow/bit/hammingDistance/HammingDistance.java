package cn.meow.bit.hammingDistance;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int val = x ^ y;
        //最低位的1 ~val+1 == -val
        int one, oneSqrt;
        int distance = 0;
        while (val > 0) {
            one = val & (~val + 1);
            oneSqrt = (int) (Math.log(one) / Math.log(2.0));
            val = val >> (oneSqrt + 1);
            distance++;
        }
        return distance;
    }
}
