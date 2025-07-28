package com.neetcode.arraynhashing;

import java.util.*;

public class LongestConsecutiveSequence {
    // Solution 1
    public int longestConsecutiveS1(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int max = count;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - 1 == nums[i-1]) {
                count++;
                max = Math.max(max, count);
            } else if (nums[i] - nums[i-1] > 1) {
                count = 1;
            }
        }
        return max;
    }

    // Solution 2
    public int longestConsecutiveS2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int best = 0;
        for(int n : set) {
            if(!set.contains(n - 1)) {  // only check for one direction
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }
}
