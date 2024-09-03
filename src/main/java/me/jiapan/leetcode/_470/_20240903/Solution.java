package me.jiapan.leetcode._470._20240903;

public class Solution {
    public int rand10() {
        while (true) {
            int val = (rand7() - 1) * 7 + rand7();
            if (val <= 40) {
                return (val - 1) % 10 + 1;
            }
        }
    }

    public int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Solution().rand10());
        }
    }
}
