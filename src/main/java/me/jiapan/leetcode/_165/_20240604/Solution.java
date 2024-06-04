package me.jiapan.leetcode._165._20240604;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        for (int i = 0; i < v1s.length || i < v2s.length; i++) {
            int x = 0, y = 0;
            if (i < v1s.length) {
                x = Integer.parseInt(v1s[i]);
            }
            if (i < v2s.length) {
                y = Integer.parseInt(v2s[i]);
            }

            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}
