package me.jiapan.leetcode._76._20240813;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int l = 0, r = -1;
        int sL = -1, sR = -1;

        while (r < s.length()) {
            r++;
            if (r < s.length() && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sL = l;
                    sR = l + minLen;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                }
                l++;
            }
        }
        return sL == -1 ? "" : s.substring(sL, sR);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> oriEntrySet : ori.entrySet()) {
            if (cnt.getOrDefault(oriEntrySet.getKey(), 0) < oriEntrySet.getValue()) {
                return false;
            }
        }
        return true;
    }
}
