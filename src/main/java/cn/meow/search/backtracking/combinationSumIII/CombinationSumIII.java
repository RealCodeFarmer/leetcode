package cn.meow.search.backtracking.combinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        //生成数组1-9
        int[] vals = new int[9];
        for (int i = 0; i < 9; i++) {
            vals[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        backtracking(k, n, vals, result, new ArrayList<>(), new boolean[9],0);
        return result;
    }

    /**
     * @param k 个数
     * @param n 和
     */
    private void backtracking(int k, int n, final int[] vals, List<List<Integer>> result, List<Integer> combination, boolean[] isVisit, int start) {
        //终止条件
        if (n == 0 && combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < vals.length; i++) {
            //处理节点
            if (isVisit[i]) {
                continue;
            }
            if (n < vals[i]) {
                return;
            }
            isVisit[i] = true;
            combination.add(vals[i]);
            //递归
            backtracking(k, n - vals[i], vals, result, combination, isVisit, i + 1);
            //回溯
            isVisit[i] = false;
            combination.remove(combination.size() - 1);
        }
    }
}
