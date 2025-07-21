package com.neetcode.twopointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c >= 'a' && c <='z' || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        String normalized = sb.toString();
        int left = 0;
        int right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) return false;
            left++;
            right --;
        }
        return true;
    }
}
