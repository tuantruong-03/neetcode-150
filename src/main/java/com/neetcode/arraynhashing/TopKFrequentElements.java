package com.neetcode.arraynhashing;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {

    }
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        // Map: Number - Frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Tuple> tuples = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            tuples.add(new Tuple(entry.getKey(), entry.getValue()));
        }
        tuples.sort((a, b) -> b.freq - a.freq);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = tuples.get(i).num;
        }
        return result;
    }

    record Tuple(int num, int freq) {}
}
