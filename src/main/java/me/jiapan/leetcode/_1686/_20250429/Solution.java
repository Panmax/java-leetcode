package me.jiapan.leetcode._1686._20250429;

import java.util.Arrays;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] values = new int[n][3];
        for (int i = 0; i < n; i++) {
            values[i][0] = aliceValues[i] + bobValues[i];
            values[i][1] = aliceValues[i];
            values[i][2] = bobValues[i];
        }
        Arrays.sort(values, (a, b) -> b[0] - a[0]);
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += values[i][1];
            } else {
                bob += values[i][2];
            }
        }
        return Integer.compare(alice, bob);
    }
}