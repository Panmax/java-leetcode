package me.jiapan.leetcode._207._20240923;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        indeg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            indeg[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer c = queue.poll();
            res.add(c);
            for (Integer i : edges.get(c)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return res.size() == numCourses;
    }
}
