package com.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private final List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return List.of();

        // Start backtracking:
        // sb = current string being built
        // openingParenthesis = number of '(' used so far
        // balance = current open - close count
        backtrack(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(StringBuilder sb, int openingParenthesis, int balance, int n) {
        // If at any time closing brackets exceed opening ones,
        // this path is invalid → prune early
        if (balance < 0) {
            return;
        }
        String str = sb.toString();
        if (str.length() == n * 2) {
            result.add(sb.toString());
            return;
        }
        if (openingParenthesis < n) {
            sb.append('(');
            backtrack(sb, openingParenthesis + 1, balance + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(')');
        backtrack(sb, openingParenthesis, balance - 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}

/*
*
class Solution {
      private final List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n);
        return result;
    }

    private void backtrack(StringBuilder sb, int n) {
        String str = sb.toString();
        if (str.length() == n*2) {
            if (isValid(str)) result.add(str);
            return;
        }
        sb.append('(');
        backtrack(sb, n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        backtrack(sb,n);
        sb.deleteCharAt(sb.length() - 1);
    }

    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (Character c : str.toCharArray()) {
            if (c == '(') {
                s.push(c);
                continue;
            }
            if (s.isEmpty()) return false;
            s.pop();
        }
        return s.isEmpty();
    }
}
* */
