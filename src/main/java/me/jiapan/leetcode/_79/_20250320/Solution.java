package me.jiapan.leetcode._79._20250320;

public class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int w = board.length;
        int h = board[0].length;
        boolean[][] visited = new boolean[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                boolean flag = check(board, i, j, visited, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int i, int j, boolean[][] visited, String word, int k) {
        if (word.charAt(k) != board[i][j]) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean flag = false;
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && !visited[newI][newJ]) {
                if (check(board, newI, newJ, visited, word, k + 1)) {
                    flag = true;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return flag;
    }
}
