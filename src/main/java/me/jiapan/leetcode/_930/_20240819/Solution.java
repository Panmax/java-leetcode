package me.jiapan.leetcode._930._20240819;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        int sum = 0;
        cnt.put(0, 1);
        for (int num : nums) {
            sum += num;
            ans += cnt.getOrDefault(sum - goal, 0);
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
