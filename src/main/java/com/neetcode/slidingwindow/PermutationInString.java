package com.neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PermutationInString {
    public static void main(String[] args) {
        new PermutationInString().checkInclusion("adc", "dcda");
    }

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        Map<Character, Integer> s1Map = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            int count = s1Map.getOrDefault(c, 0);
            s1Map.put(c, count + 1);
        }
        int left = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int right = 0; right < s2.length(); ++right) {
            char c = s2.charAt(right);
            if (s1Map.containsKey(c)) {
                int count = windowMap.getOrDefault(c, 0);
                windowMap.put(c, count + 1);
                if (right - left + 1 == s1Len) {
                    if (windowMap.equals(s1Map)) return true;
                    char leftChar = s2.charAt(left);
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    left++;
                }
            } else {
                left = right + 1;
                windowMap.clear();
            }
        }
        return false;
    }
}
