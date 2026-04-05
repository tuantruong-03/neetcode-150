package com.neetcode.dynamicprogramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;

        // Base case:
        // If there is only 1 house, the best we can do is rob it.
        if (n == 1) {
            return nums[0];
        }

        // Base case:
        // If there are 2 houses, we can only choose the richer one
        // because adjacent houses cannot both be robbed.
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // dp[i] = maximum money that can be robbed
        // from the first i houses.
        int[] dp = new int[n + 1];

        // First house only
        dp[1] = nums[0];

        // Best choice between first 2 houses
        dp[2] = Math.max(nums[0], nums[1]);

        // For each house i:
        // - Rob current house: nums[i - 1] + dp[i - 2]
        // - Skip current house: dp[i - 1]
        // Take the better option.
        for (int i = 3; i <= n; ++i) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        // Final answer = best result considering all houses
        return dp[n];
    }
}
