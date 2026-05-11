package com.neetcode.twopointers;

public class TwoSumIIAndInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0;
        int r = len -1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) return new int[]{l +1,r +1};
            if (numbers[r] + numbers[l] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}


class TwoSumIIAndInputArrayIsSortedPractice {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return  new int[]{-1, -1};
    }
}