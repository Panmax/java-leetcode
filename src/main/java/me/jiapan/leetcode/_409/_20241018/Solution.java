package me.jiapan.leetcode._409._20241018;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer counter = m.getOrDefault(c, 0);
            counter++;
            m.put(c, counter);
        }
        int res = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : m.entrySet()) {
            res += characterIntegerEntry.getValue() / 2 * 2;
            if (characterIntegerEntry.getValue() % 2 == 1 && res % 2 == 0) {
                res += 1;
            }
        }

        return res;
    }
}
