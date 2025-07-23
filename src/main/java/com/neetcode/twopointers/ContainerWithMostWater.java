package com.neetcode.twopointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;       // Get the number of vertical lines.
        int l = 0;                     // Initialize the left pointer at the start of the array.
        int r = len - 1;              // Initialize the right pointer at the end of the array.
        int max = 0;                  // Initialize the variable to store the maximum area found.

        // Iterate while left pointer is to the left of the right pointer
        while (l < r) {
            // Height is limited by the shorter line (to prevent spilling)
            int h = Math.min(height[l], height[r]);
            // Width is the distance between the two lines
            int w = r - l;
            // Update max area if the current one is larger
            max = Math.max(max, w * h);

            // Move the pointer pointing to the shorter line
            if (height[l] < height[r]) {
                l++;                // Move left pointer rightward to try and find a taller line
            } else if (height[l] > height[r]) {
                r--;                // Move right pointer leftward to try and find a taller line
            } else {
                // If both lines are equal in height, move both inward
                l++;
                r--;
            }
        }

        return max; // Return the largest area found
    }
}
