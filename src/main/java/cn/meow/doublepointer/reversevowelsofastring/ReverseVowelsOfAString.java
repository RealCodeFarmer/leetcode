package cn.meow.doublepointer.reversevowelsofastring;

public class ReverseVowelsOfAString {

    /**
     * 双指针
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (head < tail) {
            if (!"aeiouAEIOU".contains(chars[head] + "")) {
                head++;
            } else {
                if (!"aeiouAEIOU".contains(chars[tail] + "")) {
                    tail--;
                } else {
                    //swap
                    char temp = chars[head];
                    chars[head] = chars[tail];
                    chars[tail] = temp;
                    head++;
                    tail--;
                }
            }
        }
        return new String(chars);
    }
}
