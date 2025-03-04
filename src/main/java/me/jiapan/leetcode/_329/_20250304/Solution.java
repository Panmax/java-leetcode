package me.jiapan.leetcode._329._20250304;

public class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] memo;

    int row, column;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        row = matrix.length;
        column = matrix[0].length;
        memo = new int[row][column];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j] = 1;
        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newColumn = j + direction[1];
            if (newRow >= 0 && newRow < row && newColumn >= 0 && newColumn < column && matrix[newRow][newColumn] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, newRow, newColumn) + 1);
            }
        }
        return memo[i][j];
    }
}
