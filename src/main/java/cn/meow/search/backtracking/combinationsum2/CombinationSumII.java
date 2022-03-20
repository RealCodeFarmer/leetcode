package cn.meow.search.backtracking.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isVisit = new boolean[candidates.length];
        backtracking(candidates, target, result, new ArrayList<>(), isVisit, 0);
        return result;
    }

    private void backtracking(final int[] candidates, int target, List<List<Integer>> result, List<Integer> combination, boolean[] isVisit, int start) {
        //终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i != 0 && candidates[i] == candidates[i - 1] && !isVisit[i - 1]) {
                continue;
            }
            //处理节点
            isVisit[i] = true;
            combination.add(candidates[i]);
            //递归
            backtracking(candidates, target - candidates[i], result, combination, isVisit, i + 1);
            //回溯
            isVisit[i] = false;
            combination.remove(combination.size() - 1);
        }
    }
}
