package cn.meow.search.backtracking.subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {
    private List<String> visitList = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtracking(final int[] nums, List<List<Integer>> result, List<Integer> subset, int start) {
        if (!isVisit(subset)){
            result.add(new ArrayList<>(subset));
        }
        for (int i = start; i < nums.length; i++) {
            //处理节点
            subset.add(nums[i]);
            //递归
            backtracking(nums, result, subset, i + 1);
            //回溯
            subset.remove(subset.size() - 1);
        }
    }

    private boolean isVisit(List<Integer> subset){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subset.size(); i++) {
            if (i!=0) {
                sb.append(",");
            }
            sb.append(subset.get(i));
        }
        if (!visitList.contains(sb.toString())) {
            visitList.add(sb.toString());
            return false;
        }
        return true;
    }
}
