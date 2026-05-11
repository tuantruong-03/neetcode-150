package com.neetcode.dynamicprogramming;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return "";
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() -1 ;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
