package com.neetcode.arraynhashing;


import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
