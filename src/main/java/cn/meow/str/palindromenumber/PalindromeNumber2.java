package cn.meow.str.palindromenumber;

public class PalindromeNumber2 {

    /**
     * x: ABCD right: 0 ==>
     * x: AB right: DC
     */
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        //x == right / 10; 解决奇数位问题
        return x == right || x == right / 10;
    }
}
