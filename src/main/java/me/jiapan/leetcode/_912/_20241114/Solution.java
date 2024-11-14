package me.jiapan.leetcode._912._20241114;

public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int i = l, j = r;
            int pivot = nums[l];
            while (i < j) {
                // 先处理 j
                while (i < j && nums[j] >= pivot) {
                    j--;
                }
                while (i < j && nums[i] <= pivot) {
                    i++;
                }

                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            nums[l] = nums[i];
            nums[i] = pivot;
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }
}
