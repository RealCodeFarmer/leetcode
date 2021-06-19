package cn.meow.divideConquer.addParentheses;

import java.util.*;

public class AddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.length() <= 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> curRes = new ArrayList<>();
        char[] charArray = expression.toCharArray();
        for (int i = 0; i < expression.length(); i++) {
            char c = charArray[i];
            //运算符 每次有运算符出现,都把左右两边看作整体
            if (c == '+' || c == '-' || c == '*') {
                //当前运算符左边
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                //当前运算符右边
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                for (int leftNum : leftList) {
                    for (int rightNum : rightList) {
                        if (c == '+') {
                            curRes.add(leftNum + rightNum);
                        } else if (c == '-') {
                            curRes.add(leftNum - rightNum);
                        } else {
                            curRes.add(leftNum * rightNum);
                        }
                    }
                }
            }
        }
        if (curRes.isEmpty()) {
            curRes.add(Integer.valueOf(expression));
        }
        return curRes;
    }
}
