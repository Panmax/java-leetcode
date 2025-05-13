package me.jiapan.leetcode._724._20250513;

import java.util.Arrays;

public class Solution {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        // sum = total - nums[i] - sum
        // 2sum = total - nums[i]
        // 2sum + nums[i] = total
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
