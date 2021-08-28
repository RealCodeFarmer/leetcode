package cn.meow.str.isomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.trim().length() == 0 ||
                t == null || t.trim().length() == 0 ||
                s.length() != s.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char sVal = sChars[i];
            char tVal = tChars[i];
            //s->t
            if (map.containsKey(sVal)) {
                Character character = map.get(sVal);
                if (character != tVal) {
                    return false;
                }
            } else {
                map.put(sVal, tVal);
            }
            //t->s
            if (map2.containsKey(tVal)) {
                Character character = map2.get(tVal);
                if (character != sVal) {
                    return false;
                }
            } else {
                map2.put(tVal, sVal);
            }
        }
        return true;
    }
}
