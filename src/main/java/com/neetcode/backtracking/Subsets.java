package com.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> global = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, new ArrayList<>(), nums);
        return global;
    }

    private void backtrack(int index, List<Integer> subset, int []nums) {
        global.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; ++i) {
            subset.add(nums[i]);
            backtrack(i + 1, subset, nums);
            subset.removeLast();
        }
    }
}