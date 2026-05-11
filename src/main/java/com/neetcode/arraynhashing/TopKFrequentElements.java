package com.neetcode.arraynhashing;

import java.util.*;

public class TopKFrequentElements {
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

class TopKFrequentElementsPractice {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>(nums.length);
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency.
        // buckets[i] contains all numbers that appear exactly i times.
        // Since higher frequency maps to higher index,
        // iterating from the end gives most frequent elements first.
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // Step 3: Collect result (no stream, no addAll)
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) return result;
                }
            }
        }

        return result;
    }
}