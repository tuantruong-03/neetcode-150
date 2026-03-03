package com.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {
    private final List<List<String>> global = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return global;
    }

    public void backtrack(String s, int index, List<String> path) {
        if (index == s.length()) {
            global.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); ++i) {

            // Generate substring s[index ... i]
            String part = s.substring(index, i + 1);

            // Only continue exploring if substring is palindrome
            if (isPalindrome(part)) {
                path.add(part);
                backtrack(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}

/*
Should write a tree to list all cases below
a a b c
a a bc
a ab c
a abc
aa b c
aa bc
aab c
aabc
* */



// Brute-force with filtering
//public class PalindromePartitioning {
//    private final List<List<String>> result = new ArrayList<>();
//
//    // Entry point
//    public List<List<String>> partition(String s) {
//        // There are (n - 1) possible cut positions between characters
//        BitSet bitSet = new BitSet(s.length() - 1);
//
//        // Enumerate all possible cut combinations
//        backtrack(s, bitSet);
//
//        return result;
//    }
//
//    public void backtrack(String s, BitSet bitSet) {
//
//        // Build partition based on current bitmask
//        List<String> partition = partition(s, bitSet);
//
//        // If partition is valid (all substrings are palindrome),
//        // add it to result
//        if (!partition.isEmpty())
//            result.add(partition);
//
//        // Stop when all bits are 1 (last combination reached)
//        if (bitSet.isAllFlipped()) {
//            return;
//        }
//
//        bitSet.increment();
//        backtrack(s, bitSet);
//    }
//
//    // Build partition using bitmask
//    public List<String> partition(String s, BitSet bitSet) {
//
//        List<String> res = new ArrayList<>();
//
//        // Start first substring with first character
//        StringBuilder sb =
//                new StringBuilder(String.valueOf(s.charAt(0)));
//
//        for (int i = 1; i < s.length(); ++i) {
//
//            // If bit is flipped → cut here
//            if (bitSet.isFlipped(i - 1)) {
//
//                String part = sb.toString();
//
//                // Early rejection if not palindrome
//                if (!isPalindrome(part))
//                    return List.of();
//
//                res.add(part);
//                sb.setLength(0);
//            }
//
//            sb.append(s.charAt(i));
//        }
//
//        // Add final substring
//        if (!sb.isEmpty()) {
//            String part = sb.toString();
//            if (!isPalindrome(part))
//                return List.of();
//
//            res.add(part);
//        }
//
//        return res;
//    }
//
//    // Standard two-pointer palindrome check
//    public boolean isPalindrome(String s) {
//        int i = 0;
//        int j = s.length() - 1;
//
//        while (i < j) {
//            if (s.charAt(i) != s.charAt(j))
//                return false;
//            i++;
//            j--;
//        }
//
//        return true;
//    }
//
//    // Custom binary counter representing cut positions
//    public static class BitSet {
//
//        int[] arr;  // each bit indicates whether to cut at that position
//
//        BitSet(int nbits) {
//            arr = new int[nbits];
//        }
//
//        // Binary increment
//        public void increment() {
//            if (arr.length == 0)
//                return;
//
//            int remain = 1;
//
//            for (int i = arr.length - 1; i >= 0; --i) {
//                arr[i] += remain;
//                remain = 0;
//
//                if (arr[i] > 1) {
//                    arr[i] = 0;
//                    remain = 1;
//                }
//            }
//        }
//
//        public boolean isFlipped(int index) {
//            return arr[index] == 1;
//        }
//
//        // True when all bits are 1 (last combination)
//        public boolean isAllFlipped() {
//            for (int bit : arr) {
//                if (bit == 0)
//                    return false;
//            }
//            return true;
//        }
//    }
//}

/*

"aabc"
partitions=
0 0 0 -> aabc // O is no cut, 1 is cut
0 0 1 -> aab c
0 1 0 -> aa bc
0 1 1 -> aa b c
1 0 0 -> a abc
1 0 1 -> a ab c
1 1 0 -> a a bc
1 1 1 -> a a b c

* */