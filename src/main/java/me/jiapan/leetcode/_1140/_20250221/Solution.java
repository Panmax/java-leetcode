package me.jiapan.leetcode._1140._20250221;

public class Solution {
    int[] prefixSum;
    int n;
    int[][] memo;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        prefixSum = new int[n + 1];
        // prefixSum[i]表示前i堆石子的总和
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }
        memo = new int[n][n];
        return dfs(0, 1);
    }

    // 定义dfs(i,M)表示当前玩家从piles[i]开始拿石子
    public int dfs(int i, int M) {
        if (i >= n) {
            return 0;
        }
        // 如果剩下的石子数量不超过2*M，那么当前玩家可以拿走剩下的所有石子
        if (2 * M >= n - i) {
            return prefixSum[n] - prefixSum[i];
        }
        // 如果之前计算过，直接返回
        if (memo[i][M] != 0) {
            return memo[i][M];
        }
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            // 如果当前玩家在本回合拿了x堆石子，根据dfs的定义，在这之后的所有回合中，对手总共可以拿走dfs(i+X,max(M,x))颗石子
            // dfs(i + x, Math.max(x, M)) 对方最多拿的
            // prefixSum[n] - prefixSum[i] 剩余的石子数量
            // prefixSum[n] - prefixSum[i] - dfs(i + x, Math.max(x, M)) 我最多拿的
            res = Math.max(res, prefixSum[n] - prefixSum[i] - dfs(i + x, Math.max(x, M)));
        }
        memo[i][M] = res;
        return res;
    }
}