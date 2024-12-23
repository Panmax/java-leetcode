package me.jiapan.leetcode._5._20241223;

public class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int minLeft = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int length = 1;
            int left = i - 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                length++;
            }
            int right = i + 1;
            while (right < len && s.charAt(right) == s.charAt(i)) {
                right++;
                length++;
            }
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                length += 2;
            }
            if (length > maxLength) {
                maxLength = length;
                minLeft = left;
            }
        }
        return s.substring(minLeft + 1, minLeft + 1 + maxLength);
    }
}
