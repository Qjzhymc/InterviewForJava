package Algorithm4th.左程云算法课程.图;

import java.sql.Array;
import java.util.*;

public class 课程表 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> map = new HashMap<>();//每一个节点的出度
        for(int[] pre: prerequisites) {
            int f = pre[0];
            map.put(f, map.getOrDefault(f, 0) + 1);
        }



        Queue<Integer> queue = new LinkedList<>();//保存所有出度为0节点
        for (int i =0;i<numCourses; i++) {
            if (map.get(i) == null) {
                queue.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for (int[] pre: prerequisites) {
                if (pre[1] == cur) {
                    int left = map.get(pre[0]) -1; //pre[0]节点剩余的出度
                    if (left <=0) {
                        queue.add(pre[0]);
                    } else {
                        map.put(pre[0], left);
                    }
                }
            }
        }
        return res.size() == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses, prerequisites));

    }
}
