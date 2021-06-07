package cn.meow.sort.sortCharactersByFrequency;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            //降序排序
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            Character key = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
