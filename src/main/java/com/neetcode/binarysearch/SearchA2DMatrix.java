package com.neetcode.binarysearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
         // Flatten 2D to 1D
        int l = 0;
        int r = m*n -1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            int val = matrix[mid/n][mid%n];
            if (val == target) return true;
            else if (val > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
