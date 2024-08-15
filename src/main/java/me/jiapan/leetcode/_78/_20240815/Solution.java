package me.jiapan.leetcode._78._20240815;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < 1 << n; mask++) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    tmp.add(nums[i]);
                }
            }
            ans.add(tmp);
        }

        return ans;
    }
}
