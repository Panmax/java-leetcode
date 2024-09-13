package me.jiapan.leetcode._402._20240913;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.getLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        boolean firstZero = true;
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            Character c = deque.pollFirst();
            if (firstZero && c == '0') {
                continue;
            }
            firstZero = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
