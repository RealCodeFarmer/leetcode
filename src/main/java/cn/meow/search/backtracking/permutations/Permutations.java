package cn.meow.search.backtracking.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(permuteList, nums, result, visited);
        return result;
    }

    private void backtracking(List<Integer> permuteList, int[] nums, List<List<Integer>> result, boolean[] visited) {
        //终止条件
        if (permuteList.size() == nums.length) {
            result.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //处理节点
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            //递归
            backtracking(permuteList, nums, result, visited);
            //回溯
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}
