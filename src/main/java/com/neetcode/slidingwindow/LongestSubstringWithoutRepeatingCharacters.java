package com.neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringS1("tmmzuxt");
    }

    // Solution 1
    public int lengthOfLongestSubstringS1(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int globalMax = 0;
        int localLength  = 0;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                globalMax = Math.max(globalMax, localLength);
                int lastSeen = map.get(c);
                localLength = i - lastSeen;
                map.clear();
                int j = lastSeen + 1;
                while (j <= i) {
                    map.put(s.charAt(j), j);
                    j++;
                }
                continue;
            }
            map.put(c, i);
            localLength++;
            globalMax = Math.max(globalMax, localLength);
        }
        return globalMax;
    }

    // Solution 2
    public int lengthOfLongestSubstringS2(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < len; ++right) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
