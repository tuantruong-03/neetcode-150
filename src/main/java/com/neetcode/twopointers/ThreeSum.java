package com.neetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len  = nums.length;
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < len;  ++i) {
            if (i > 0 && nums[i-1] == nums[i]) continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (l > i + 1 && nums[l-1] == nums[l]) {
                    l++;
                    continue;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    triplets.add(List.of(nums[i],nums[l], nums[r]));
                    r--;
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return triplets;
    }
}
