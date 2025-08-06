package com.neetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                int num = Integer.parseInt(token);
                numStack.push(num);
                continue;
            }
            if (numStack.isEmpty()) {
                return 0;
            }
            int opt2 = numStack.pop();
            int opt1= numStack.pop();
            int result = calculate(opt1, opt2, token);
            numStack.push(result);
        }
        return numStack.pop();
    }

    private Integer calculate(int opt1, int opt2, String operator) {
        return switch (operator) {
            case "+" -> opt1 + opt2;
            case "-" -> opt1 - opt2;
            case "*" -> opt1 * opt2;
            case "/" -> opt1 / opt2;
            default -> 0;
        };
    }
}
