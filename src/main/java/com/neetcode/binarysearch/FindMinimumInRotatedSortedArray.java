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

class FindMinimumInRotatedSortedArrayPractice {
    public int findMin(int[] nums) {
        int l = 0;
        int r  = nums.length - 1;
        if (nums[l] <= nums[r]) return nums[l];
        while (l < r) {
            int m = (l+r)/2;
            if (l == m) return nums[r];
            if (nums[m] > nums[r]) {
                l = m;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}