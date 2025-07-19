package com.neetcode.arraynhashing;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        // Map: Number - Index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0 ; i < nums.length; i++){
            map.put(nums[i], i);
        }
        int []result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[] { map.get(other), i };
            }
        }
        return result;
    }
}
