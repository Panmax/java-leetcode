package me.jiapan.leetcode._40._20240929;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<int[]> freq;
    List<List<Integer>> ans;
    List<Integer> sequence;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        freq = new ArrayList<>();
        ans = new ArrayList<>();
        sequence = new ArrayList<>();

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

    public void dfs(int index, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (index == freq.size() || freq.get(index)[0] > rest) {
            return;
        }
        dfs(index + 1, rest);
        int most = Math.min(freq.get(index)[1], rest / freq.get(index)[0]);
        // i=1; <=
        for (int i = 1; i <= most; i++) {
            sequence.add(freq.get(index)[0]);
            dfs(index + 1, rest - freq.get(index)[0] * i);
        }
        for (int i = 1; i <= most; i++) {
            sequence.remove(sequence.size() - 1);
        }
    }
}
