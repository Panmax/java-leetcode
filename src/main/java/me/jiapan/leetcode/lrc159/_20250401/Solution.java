package me.jiapan.leetcode.lrc159._20250401;

import java.util.Arrays;

public class Solution {
    public int[] inventoryManagement(int[] stock, int cnt) {
        int[] res = new int[cnt];
        Arrays.sort(stock);
        System.arraycopy(stock, 0, res, 0, cnt);
        return res;
    }
}
