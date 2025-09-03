package com.neetcode.binarysearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) return nums[left]; // Rotated 0 time
            int mid = (left + right) / 2;
            if (left == mid) return nums[right];
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
