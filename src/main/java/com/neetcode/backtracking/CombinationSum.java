package com.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> global = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            path.add(candidates[i]);
            backtrack(i, remain - candidates[i], path, candidates);
            path.removeLast();
        }
    }

}

class CombinationSumPractice {
    private List<List<Integer>> global = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, target, new ArrayList<>(), candidates);
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
            path.add(candidates[i]);
            backtrack(i, remain - candidates[i], path, candidates);
            path.remove(path.size() -1);
        }
    }
}