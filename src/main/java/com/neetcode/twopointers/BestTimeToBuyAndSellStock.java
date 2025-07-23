package com.neetcode.twopointers;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int prev = 0;
        int curr = prev + 1;
        int max = 0;

        while (curr < len) {
            // Calculate the profit between curr (sell) and prev (buy)
            int profit = prices[curr] - prices[prev];

            // Update max if this profit is better than previous max
            max = Math.max(max, profit);

            // If current price is greater than or equal to prev price,
            // it's okay to check next day as a potential better sell
            if (prices[prev] <= prices[curr]) {
                curr++;
            } else {
                // If prices[curr] < prices[prev], we found a better (lower) buy day
                // Move prev to curr, and check future days from here
                prev = curr;
                curr++;
            }
        }
        return max;
    }
}
