package cn.meow.search.backtracking.combinationSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0, candidates, new ArrayList<>(), result, target);
        return result;
    }

    private void backtracking(int begin, int[] candidates, List<Integer> permuteList, List<List<Integer>> result, int target) {
        //终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            //处理节点
            if (candidates[i] > target) {
                continue;
            }
            permuteList.add(candidates[i]);
            //递归
            backtracking(i, candidates, permuteList, result, target - candidates[i]);
            //回溯
            permuteList.remove(permuteList.size() - 1);
        }
    }
}
