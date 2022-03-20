package cn.meow.sort.sortcolors;

import java.util.HashMap;
import java.util.Map;

/**
 * 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
 */
public class SortColors {

    /**
     * 哈希
     */
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                nums[index] = key;
                index++;
            }
        }
    }

    /**
     * 数组
     */
    public void sortColors2(int[] nums) {
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[index] = i;
                index++;
            }
        }
    }
}
