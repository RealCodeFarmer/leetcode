package cn.meow.search.backtracking.combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] vals = new int[n];
        boolean[] isVisit = new boolean[n];
        for (int i = 0; i < n; i++) {
            vals[i] = i + 1;
        }
        backtracking(vals, result, k, new ArrayList<>(), isVisit);
        return result;
    }

    private void backtracking(int[] vals, List<List<Integer>> result, int k, List<Integer> combine, boolean[] isVisit) {
        //终止条件
        if (combine.size() == k) {
            result.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < vals.length; i++) {
            //处理节点
            if (isVisit[i]) {
                continue;
            }
            if (combine.size() >= k) {
                return;
            }
            if (combine.size() >= 1 && combine.get(combine.size() - 1) >= vals[i]) {
                continue;
            }
            isVisit[i] = true;
            combine.add(vals[i]);
            //递归
            backtracking(vals, result, k, combine, isVisit);
            //回溯
            combine.remove(combine.size() - 1);
            isVisit[i] = false;
        }
    }
}
