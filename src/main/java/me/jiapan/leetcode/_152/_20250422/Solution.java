package me.jiapan.leetcode._152._20250422;

public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long[] dpMax = new long[n];
        long[] dpMin = new long[n];
        for (int i = 0; i < n; i++) {
            dpMax[i] = nums[i];
            dpMin[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
        }
        long max = dpMax[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dpMax[i]);
        }
        return (int) max;
    }
}
