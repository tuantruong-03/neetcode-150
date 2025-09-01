package com.neetcode.binarysearch;


import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left <= right) {
            int mid = (left +right) /2;
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceilDivExact(pile,mid);
            }
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
