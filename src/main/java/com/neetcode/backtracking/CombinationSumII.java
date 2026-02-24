package com.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private List<List<Integer>> global = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0 , target, new ArrayList<>(), candidates);
        return global;
    }

    private void backtrack(int index, int remain, List<Integer> path, int[] candidates) {
        if (remain == 0) {
            global.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            if (remain < candidates[i]) {
                break;
            }
            if (i > index && candidates[i] == candidates[i-1]) continue; // Avoid duplicate
            path.add(candidates[i]);
            backtrack(i + 1, remain - candidates[i], path, candidates);
            path.removeLast();
        }
    }
}
