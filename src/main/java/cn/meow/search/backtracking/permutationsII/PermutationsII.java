package cn.meow.search.backtracking.permutationsII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsII {
    private List<String> results = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
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
        if (nums.length == permuteList.size()) {
            String joinStr = joinStr(permuteList);
            if (!results.contains(joinStr)) {
                result.add(new ArrayList<>(permuteList));
                results.add(joinStr);
            }
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
            visited[i] = false;
            permuteList.remove(permuteList.size() - 1);
        }
    }

    private String joinStr(List<Integer> permuteList) {
        return permuteList.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}
