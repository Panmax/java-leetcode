package me.jiapan.leetcode._229._20241015;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = nums[0];
        int num2 = nums[0];
        int counter1 = 0;
        int counter2 = 0;

        for (int num : nums) {
            if (num1 == num) {
                counter1++;
                continue;
            }
            if (num2 == num) {
                counter2++;
                continue;
            }
            if (counter1 == 0) {
                num1 = num;
                counter1++;
                continue;
            }
            if (counter2 == 0) {
                num2 = num;
                counter2++;
                continue;
            }
            counter1--;
            counter2--;
        }
        counter1 = 0;
        counter2 = 0;
        for (int num : nums) {
            if (num1 == num) {
                counter1++;
            } else if (num2 == num) {
                counter2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (counter1 > nums.length / 3) {
            res.add(num1);
        }
        if (counter2 > nums.length / 3) {
            res.add(num2);
        }
        return res;
    }
}
