package com.neetcode.dynamicprogramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        // n >= 3
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        dp[2] = cost[2] + Math.min(cost[0], cost[1]);
        for (int i = 3; i <= n; ++i) {
            int currentCost = i < n ? cost[i] : 0;
            dp[i] = currentCost + Math.min(dp[i-2], dp[i-1]);
        }
        return dp[n];
    }
}
