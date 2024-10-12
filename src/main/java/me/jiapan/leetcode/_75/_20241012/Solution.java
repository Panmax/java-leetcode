package me.jiapan.leetcode._75._20241012;

public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
        for (int i = ptr; i < n; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
    }
}
