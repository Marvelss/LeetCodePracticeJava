package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : Vagrant
 * @Time: 2025-04-12 10:01
 * @File : Solution66.java
 * @Description :207. 课程表（直接抄）
 * 总体思路：拓扑排序
 * 1.根据依赖关系，构建邻接表和入度数组
 * 2.选取入度为0的数据，根据邻接表，减小依赖它的数据的入度
 * 3.找出入度为0的数据，重复步骤2
 * 4.直到所有数据的入度为0，得到排序，若存在入度不为0.说明图中由环
 */

public class Solution66 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            inDegree[course]++;
            adjList.get(preCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int selectedCourse = queue.poll();
            cnt++;
            List<Integer> nxtCourses = adjList.get(selectedCourse);
            for (Integer nxtCourse : nxtCourses) {
                inDegree[nxtCourse]--;
                if (inDegree[nxtCourse] == 0) queue.offer(nxtCourse);
            }
        }
        return cnt == numCourses;
    }
}
