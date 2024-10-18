package me.jiapan.leetcode._1406._20241016;

public class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        int sum = 0;

        for (int i = n - 1; i >= 0; i--) {
            sum += stoneValue[i];
            dp[i] = Integer.MIN_VALUE;
            for (int j = i; j < i + 3 && j < n; j++) {
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }

        int alice = dp[0];
        int bob = sum - dp[0];
        if (alice > bob) {
            return "Alice";
        } else if (alice < bob) {
            return "Bob";
        }
        return "Tie";
    }
}
