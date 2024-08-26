package me.jiapan.leetcode._34._20240826;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = findTarget(nums, target, true);
        int rightIdx = findTarget(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length
                && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int findTarget(int[] nums, int target, boolean low) {
        int l = 0;
        int r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target || (low && nums[mid] >= target)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
