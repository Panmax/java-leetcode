package me.jiapan.leetcode.lcr121._20250107;

public class Solution {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int i = plants.length - 1;
        int j = 0;
        while (i >= 0 && j < plants[0].length) {
            if (plants[i][j] == target) {
                return true;
            } else if (plants[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
