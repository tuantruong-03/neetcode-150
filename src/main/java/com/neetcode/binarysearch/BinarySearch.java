package com.neetcode.binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                r = mid - 1;
            } else  {
                l = mid + 1;
            }
        }
        return index;
    }
}

class BinarySearchPractice {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m]) return m;
            if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
