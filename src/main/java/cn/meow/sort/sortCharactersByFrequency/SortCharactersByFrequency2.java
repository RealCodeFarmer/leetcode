package cn.meow.sort.sortCharactersByFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency2 {

    /**
     * 大顶堆(哈希)
     */
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        //优先队列 PriorityQueue(比较器)
        PriorityQueue<Map.Entry<Character, Integer>> items = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        items.addAll(count.entrySet());

        //拼接字符串
        StringBuilder sb = new StringBuilder();
        while (!items.isEmpty()) {
            //出队
            Map.Entry<Character, Integer> item = items.poll();
            char key = item.getKey();
            for (int i = 0; i < item.getValue(); i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
