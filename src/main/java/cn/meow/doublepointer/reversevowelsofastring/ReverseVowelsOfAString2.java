package cn.meow.doublepointer.reversevowelsofastring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString2 {

    private final static Set<Character> vowels = new HashSet<>(
            Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

    public String reverseVowels(String s) {
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        int head = 0;
        int tail = s.length() - 1;
        char[] chars = new char[s.length()];
        while (head <= tail) {
            char cHead = s.charAt(head);
            char cTail = s.charAt(tail);
            if (!vowels.contains(cHead)) {
                chars[head++] = cHead;
            } else if (!vowels.contains(cTail)) {
                chars[tail--] = cTail;
            } else {
                chars[head++] = cTail;
                chars[tail--] = cHead;
            }
        }
        return new String(chars);
    }
}
