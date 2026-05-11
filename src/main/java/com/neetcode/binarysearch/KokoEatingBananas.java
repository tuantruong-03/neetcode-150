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

class KokoEatingBananasPractice {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        while (l <= r) {
            int m = l - (l-r)/2; // "m" is a possible "k"
            long hours = 0;
            for (int pile : piles) {
                hours += Math.ceilDiv(pile, m);
            }
            if (hours > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new KokoEatingBananasPractice().minEatingSpeed(new int[] {805306368,805306368,805306368}, 1000000000);
    }
}
