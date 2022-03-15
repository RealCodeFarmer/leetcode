package cn.meow.search.backtracking.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtracking(final int[] nums, List<List<Integer>> result, List<Integer> subset, int start) {
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            //处理节点
            subset.add(nums[i]);
            //递归
            backtracking(nums, result, subset, i + 1);
            //回溯
            subset.remove(subset.size() - 1);
        }
    }
}
