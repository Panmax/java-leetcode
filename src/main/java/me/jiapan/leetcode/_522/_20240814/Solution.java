package me.jiapan.leetcode._522._20240814;

public class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if (i != j && checkSub(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    private boolean checkSub(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int i = 0, j = 0;
        while (i < s1Len && j < s2Len) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s1Len;
    }
}
