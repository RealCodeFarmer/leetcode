package cn.meow.graph.courseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    /**
     * 广度
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //入度(前置课程)
        List<List<Integer>> list = new ArrayList<>();
        //入度数
        int[] nums = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(i, new ArrayList<>());
        }
        //记录入度数
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
            nums[prerequisite[0]]++;
        }
        //队列
        Queue<Integer> queue = new LinkedList<>();
        //把入度为0的放入队列
        for (int i = 0; i < numCourses; i++) {
            if (nums[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer inEle : list.get(poll)) {
                nums[inEle]--;
                if (nums[inEle] == 0) {
                    queue.offer(inEle);
                }
            }
            result[index] = poll;
            index++;
        }
        //是否闭环了
        if (index != numCourses) {
            return new int[]{};
        }
        return result;
    }
}
