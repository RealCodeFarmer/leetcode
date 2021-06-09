package cn.meow.greedyThinking.queueReconstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction2 {

    /**
     * 从高到低考虑
     */
    public int[][] reconstructQueue(int[][] people) {
        //例如: [[2,4],[3,4],[9,0],[0,6],[7,1],[6,0],[7,3],[2,5],[1,1],[8,0]]
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        //排序后: 身高降序,身高相等的话人数升序 [[9,0],[8,0],[7,1],[7,3],[6,0],[3,4],[2,4],[2,5],[1,1],[0,6]]
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            //相同索引,list索引位置会向后挪出位置给新的数据放
            //因为身高是降序的, 高的人根本看不到矮的人
            ans.add(person[1], person);
        }
        //[[6,0],[1,1],[8,0],[7,1],[9,0],[2,4],[0,6],[2,5],[3,4],[7,3]]
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * 从低到高考虑
     */
    public int[][] reconstructQueue2(int[][] people) {
        //例如: [[2,4],[3,4],[9,0],[0,6],[7,1],[6,0],[7,3],[2,5],[1,1],[8,0]]
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        //排序后: 身高升序,身高相等的话人数降序[[0,6],[1,1],[2,5],[2,4],[3,4],[6,0],[7,3],[7,1],[8,0],[9,0]]
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            //因为要插到下一个空位,所以+1
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                //因为身高升序,所以前面的都比它高
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
