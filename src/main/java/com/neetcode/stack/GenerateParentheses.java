package com.neetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(4);
    }
    private List<String> f1 = List.of("()");
    private List<String> f2 = List.of("(())", "()()");
    public List<String> generateParenthesis(int n) {
        return generateParenthesisWithF1(n);
    }

    private List<String> generateParenthesisWithF1(int current) {
        if (current == 1) return f1;
        if (current == 2) return f2;
        List<String> previousResults = generateParenthesis(current -1);
        List<String> results = new ArrayList<>();
        StringBuilder firstParenthesis = new StringBuilder();
        firstParenthesis.setLength(current*2);
        int left = 0;
        int right = current*2 - 1;
        while (left < right) {
            firstParenthesis.setCharAt(left, '(');
            firstParenthesis.setCharAt(right, ')');
            left++;
            right--;
        }
        results.add(firstParenthesis.toString());
        for (int i = 0; i < previousResults.size(); ++i) {
            String result1 = f1.getLast() + previousResults.get(i);
            String result2 = previousResults.get(i) + f1.getLast();
            if (i == previousResults.size() - 1) {
                result2 = "(" + previousResults.getLast() + ")";
            }
            results.add(result1);
            results.add(result2);
        }
        return results;
    }
}
