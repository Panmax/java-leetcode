package me.jiapan.leetcode._220._20241118;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int bucketSize = valueDiff + 1;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int bucket = getBucketId(nums[i], bucketSize);
            if (m.containsKey(bucket)) {
                return true;
            }
            if (m.containsKey(bucket - 1) && Math.abs(m.get(bucket - 1) - nums[i]) <= valueDiff) {
                return true;
            }
            if (m.containsKey(bucket + 1) && Math.abs(m.get(bucket + 1) - nums[i]) <= valueDiff) {
                return true;
            }

            m.put(bucket, nums[i]);

            if (i >= indexDiff) {
                m.remove(getBucketId(nums[i - indexDiff], bucketSize));
            }
        }
        return false;
    }

    private int getBucketId(int num, int bucketSize) {
        if (num >= 0) {
            return num / bucketSize;
        }
        return (num + 1) / bucketSize - 1;
    }
}