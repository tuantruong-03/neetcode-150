package com.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
        private final List<List<Integer>> global = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrack(0, new ArrayList<>(), nums);
            return global;
        }
        private void backtrack(int index, List<Integer> path, int[] nums) {
            global.add(new ArrayList<>(path));
            for (int i = index; i < nums.length; ++i) {
                if (i > index && nums[i] == nums[i-1]) continue;
                path.add(nums[i]);
                backtrack(i + 1, path, nums);
                path.removeLast();
            }
        }
}
