package me.jiapan.leetcode._121._20241009;

public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                res = Math.max(res, price - minPrice);
            }
        }
        return res;
    }
}
