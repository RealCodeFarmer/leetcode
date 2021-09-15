package cn.meow.graph.courseSchedule;

import java.util.*;

public class CourseSchedule {

    /**
     * 超时
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List> map = new HashMap<>();
        int length = prerequisites.length;
        //存放新课程
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int[] prerequisite = prerequisites[i];
            if (prerequisite == null || prerequisites.length == 0) {
                continue;
            }
            int target = prerequisite[0];
            int pre = prerequisite[1];
            set.add(target);
            set.add(pre);
            List<Integer> list;
            if (map.containsKey(target)) {
                list = map.get(target);
            } else {
                list = new ArrayList<>();
                map.put(target, list);
            }
            if (!list.contains(pre)) {
                //如果不存在,添加进去
                list.add(pre);
                //检查是否回环
                if (check(map, target, pre)) {
                    return false;
                }
            }
            if (set.size() > numCourses) {
                return false;
            }
        }
        return true;
    }

    private boolean check(Map<Integer, List> map, int target, int checkNum) {
        if (target == checkNum) {
            return true;
        }
        if (map.containsKey(checkNum)) {
            List<Integer> list = map.get(checkNum);
            if (list != null && !list.isEmpty()) {
                for (Integer integer : list) {
                    boolean check = check(map, target, integer);
                    if (check) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
