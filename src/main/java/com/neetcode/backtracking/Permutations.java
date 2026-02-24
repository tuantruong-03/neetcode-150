package com.neetcode.backtracking;

import java.util.*;

public class Permutations {
    private final List<List<Integer>> global = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), new HashSet<>(), nums);
        return global;
    }

    private void backtrack(List<Integer> path, Set<Integer> visited, int[] nums) {
        if (path.size() == nums.length) {
            global.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            visited.add(nums[i]);
            backtrack(path, visited, nums);
            path.removeLast();
            visited.remove(nums[i]);
        }
    }
}
