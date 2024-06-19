package me.jiapan.leetcode._40._20240619;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            if (freq.isEmpty() || freq.get(freq.size() - 1)[0] != candidate) {
                freq.add(new int[]{candidate, 1});
            } else {
                freq.get(freq.size() - 1)[1]++;
            }
        }
        dfs(0, target);
        return ans;
    }

    void dfs(int pos, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(sequence));
        }
        if (pos >= freq.size() || freq.get(pos)[0] > target) {
            return;
        }
        dfs(pos + 1, target);
        int most = Math.min(target / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; i++) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, target - (i * freq.get(pos)[0]));
        }
        for (int i = 1; i <= most; i++) {
            sequence.remove(sequence.size() - 1);
        }
    }
}