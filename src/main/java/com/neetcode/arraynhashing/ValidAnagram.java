package com.neetcode.arraynhashing;


import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        // Count the occurrences of each character in string "s"
        for (Character c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        // Decrease the count for each character found in string "t"
        for (Character c : t.toCharArray()) {
            int count = sMap.getOrDefault(c, 0) - 1;
            // If count goes below zero, "t" has more of this char than "s"
            if (count < 0) {
                return false;
            }
            // Update the count in the map
            sMap.put(c, count);
        }
        // After processing, all character counts should be zero
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        // Strings are anagrams
        return true;
    }
}
