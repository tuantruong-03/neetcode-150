package com.neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindowS1("aa", "aa");
    }
    // Solution 1
    public String minWindowS1(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Shrink window while it's valid
            while (contains(windowMap, tMap)) {
                int windowLen = r - l + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = l;
                }

                char leftChar = s.charAt(l);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar); // Clean up zero-counts
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }


    private boolean contains(Map<Character, Integer> windowMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char key = entry.getKey();
            if (windowMap.getOrDefault(key, 0) < entry.getValue()) return false;
        }
        return true;
    }


    public String minWindowS2(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int have = 0;
        int need = tMap.size();
        int l = 0;
        int min = Integer.MAX_VALUE;
        int resL = 0;
        for (int r = 0; r < s.length(); ++r) {
            Character c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c,0) +1);
            if (tMap.containsKey(c) && tMap.get(c).intValue() == windowMap.get(c).intValue()) {
                have++; // Increase "have" when windowMap contains enough number of a character in tMap
            }
            while (have == need) {
                if (r - l + 1 < min) {
                    resL = l;
                    min = r - l + 1;
                }
                char leftChar = s.charAt(l);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(resL, resL + min);
    }
}
