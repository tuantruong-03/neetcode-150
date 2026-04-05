package com.neetcode.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        // Special case:
        // If there is only 1 house, we can rob it directly.
        if (nums.length == 1) {
            return nums[0];
        }

        // Since houses are arranged in a circle,
        // first and last house cannot both be robbed.
        //
        // So split into 2 valid linear cases:
        // 1. Rob from house [0 ... n-2]
        // 2. Rob from house [1 ... n-1]
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);

        // Take the better result between the 2 cases (degenerated into HouseRobber problem)
        return Math.max(rob1(nums1), rob1(nums2));
    }

    private int rob1(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n + 1];

        dp[1] = nums[0];

        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i <= n; ++i) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[n];
    }
}
