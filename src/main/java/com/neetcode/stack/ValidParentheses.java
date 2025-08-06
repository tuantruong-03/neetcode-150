package com.neetcode.stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        new ValidParentheses().isValid("()");
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c== '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            if (c == ')') {
                Character peek = stack.pop();
                if (peek != '(') return false;
            }
            if (c == '}') {
                Character peek = stack.pop();
                if (peek != '{') return false;
            }
            if (c == ']') {
                Character peek = stack.pop();
                if (peek != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
