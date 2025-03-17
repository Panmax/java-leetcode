package me.jiapan.leetcode._45._20250314;

public class Solution {
    public int jump(int[] nums) {
        int step = 0, end = 0, maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                step++;
                end = maxPosition;
            }
        }
        return step;
    }
}
